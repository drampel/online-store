package az.apple_corporation.auth.service;

import az.apple_corporation.auth.dao.AuthUserEntity;
import az.apple_corporation.auth.dao.AuthUserRepository;
import az.apple_corporation.auth.mapper.AuthMapper;
import az.apple_corporation.auth.mapper.MailMapper;
import az.apple_corporation.auth.model.RefreshTokenDto;
import az.apple_corporation.auth.model.SignUpDto;
import az.apple_corporation.auth.model.SrpStep1RequestDto;
import az.apple_corporation.auth.model.SrpStep1ResponseDto;
import az.apple_corporation.auth.model.SrpStep2RequestDto;
import az.apple_corporation.auth.model.SrpStep2ResponseDto;
import az.apple_corporation.auth.model.TokenPair;
import az.apple_corporation.auth.model.exception.AuthException;
import az.apple_corporation.auth.queue.MailSender;
import az.apple_corporation.auth.util.CacheUtil;
import az.apple_corporation.auth.util.SrpUtil;
import com.nimbusds.srp6.BigIntegerUtils;
import com.nimbusds.srp6.SRP6Exception;
import com.nimbusds.srp6.SRP6ServerSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final TokenService tokenService;
    private final AuthUserRepository authUserRepository;
    private final CacheUtil cacheUtil;
    private final MailSender mailSender;

    public AuthServiceImpl(TokenService tokenService,
                           AuthUserRepository authUserRepository,
                           CacheUtil cacheUtil,
                           MailSender mailSender) {
        this.tokenService = tokenService;
        this.authUserRepository = authUserRepository;
        this.cacheUtil = cacheUtil;
        this.mailSender = mailSender;
    }

    @Override
    public void signUp(SignUpDto signUpDto) {
        authUserRepository.save(AuthMapper.toEntity(signUpDto));
        mailSender.sendEmail(MailMapper.toMail(signUpDto.getEmail(),
                "Apple Store Registration Notice.",
                "You have successfully registered in our online Apple Store. Congratulations!"));
    }

    @Override
    public SignUpDto getUserByEmail(String email) {
        SignUpDto dto = null;
        for (AuthUserEntity entity : authUserRepository.findAll()) {
            if (entity.getEmail().equals(email)) {
                dto = AuthMapper.toDto(entity);
                break;
            }
        }
        if (dto == null) throw new AuthException("User not found");
        return dto;
    }

    @Override
    public SrpStep1ResponseDto step1(SrpStep1RequestDto srpStep1RequestDto) {
        SRP6ServerSession session = SrpUtil.getSession();
        AuthUserEntity authEntity = authUserRepository.findByEmail(srpStep1RequestDto.getEmail())
                .orElseThrow(() -> new AuthException("auth.authentication-failed", "Authentication failed"));
        BigInteger b = session.step1(authEntity.getEmail(),
                BigIntegerUtils.fromHex(authEntity.getSalt()),
                BigIntegerUtils.fromHex(authEntity.getVerifier()));
        cacheUtil.saveToCache(srpStep1RequestDto.getEmail(), session, 1L, TimeUnit.MINUTES);
        return new SrpStep1ResponseDto(authEntity.getSalt(), BigIntegerUtils.toHex(b));
    }

    @Override
    public Pair<SrpStep2ResponseDto, TokenPair> step2(SrpStep2RequestDto srpStep2RequestDto) {
        SRP6ServerSession session = cacheUtil.getBucket(srpStep2RequestDto.getEmail());
        BigInteger m2;
        try {
            m2 = session.step2(
                    BigIntegerUtils.fromHex(srpStep2RequestDto.getA()),
                    BigIntegerUtils.fromHex(srpStep2RequestDto.getM1())
            );
        } catch (SRP6Exception ex) {
            throw new AuthException("auth.authentication-failed", "Authentication failed");
        }
        AuthUserEntity authEntity = authUserRepository.findByEmail(srpStep2RequestDto.getEmail())
                .orElseThrow(() -> new AuthException("auth.authentication-failed", "Authentication failed"));
        TokenPair tp = new TokenPair(
                tokenService.generateAccessToken(authEntity.getId()),
                tokenService.generateRefreshToken(new RefreshTokenDto(authEntity.getId(), 5,
                        LocalDateTime.now().plusHours(2L))));
        return Pair.of(new SrpStep2ResponseDto(m2.toString(16)), tp);
    }

    @Override
    public Long validateAccessToken(String accessToken) {
        log.info("Validate token: {}", accessToken);
        return tokenService.validateAccessToken(accessToken);
    }

    @Override
    public TokenPair refreshTokens(String refreshToken) {
        RefreshTokenDto refreshTokenDto = tokenService.validateRefreshToken(refreshToken);
        return new TokenPair(tokenService.generateAccessToken(refreshTokenDto.getUserId()),
                tokenService.generateRefreshToken(refreshTokenDto));
    }
}