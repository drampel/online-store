package az.apple_corporation.auth.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.extern.slf4j.Slf4j;
import az.apple_corporation.auth.dao.ActiveRefreshTokenEntity;
import az.apple_corporation.auth.dao.ActiveRefreshTokenRepository;
import az.apple_corporation.auth.model.RefreshTokenDto;
import az.apple_corporation.auth.model.exception.AuthException;
import az.apple_corporation.auth.util.DateUtil;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;

import static az.apple_corporation.auth.model.constants.ErrorCodes.ACCESS_TOKEN_EXPIRED;
import static az.apple_corporation.auth.model.constants.ErrorCodes.REFRESH_TOKEN_EXPIRED;
import static az.apple_corporation.auth.model.constants.PayloadFields.COUNT;
import static az.apple_corporation.auth.model.constants.PayloadFields.EXPIRATION_TIME;
import static az.apple_corporation.auth.model.constants.PayloadFields.USER_ID;
import static az.apple_corporation.auth.model.constants.PayloadFields.UUID;
import static az.apple_corporation.auth.util.PayloadUtil.extractField;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    private final RSAKey rsaJWK;
    private final ActiveRefreshTokenRepository activeRefreshTokenRepository;
    public TokenServiceImpl(ActiveRefreshTokenRepository activeRefreshTokenRepository) throws Exception {
        this.activeRefreshTokenRepository = activeRefreshTokenRepository;
        rsaJWK = new RSAKeyGenerator(2048)
                .keyID("123")
                .generate();
    }

    @Override
    public String generateAccessToken(Long userId) {
        try {
            JWTClaimsSet claims = new JWTClaimsSet.Builder()
                    .claim(USER_ID, userId)
                    .claim(EXPIRATION_TIME, LocalDateTime.now().plusMinutes(10L).toString())
                    .build();
            JWSObject jwsObject = new JWSObject(
                    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                    claims.toPayload());
            JWSSigner signer = new RSASSASigner(rsaJWK);
            jwsObject.sign(signer);
            return jwsObject.serialize();
        } catch (Exception ex) {
            log.error("Something go wrong in jwt", ex);
            throw new AuthException("auth.generate-jwt-exception", ex.getMessage());
        }
    }

    @Override
    public String generateRefreshToken(RefreshTokenDto dto) {
        try {
            ActiveRefreshTokenEntity activeRefreshTokenEntity =
                    activeRefreshTokenRepository.save(new ActiveRefreshTokenEntity());
            JWTClaimsSet claims = new JWTClaimsSet.Builder()
                    .claim(UUID, activeRefreshTokenEntity.getUuid())
                    .claim(USER_ID, dto.getUserId())
                    .claim(EXPIRATION_TIME, dto.getExpirationTime().toString())
                    .claim(COUNT, dto.getCount())
                    .build();
            JWSObject jwsObject = new JWSObject(
                    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                    claims.toPayload());
            JWSSigner signer = new RSASSASigner(rsaJWK);
            jwsObject.sign(signer);
            return jwsObject.serialize();
        } catch (Exception ex) {
            log.error("Something go wrong in jwt", ex);
            throw new AuthException("auth.generate-jwt-exception", ex.getMessage());
        }
    }

    @Override
    public Long validateAccessToken(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier verifier = new RSASSAVerifier(rsaJWK.toPublicJWK());
            if (!jwsObject.verify(verifier)) {
                throw new AuthException("auth.invalid-token", "Token not valid");
            }
            if (DateUtil.toLocalDateTime(extractField(jwsObject, EXPIRATION_TIME))
                    .isBefore(LocalDateTime.now())) {
                log.error("Token expired, {}", extractField(jwsObject, EXPIRATION_TIME));
                throw new AuthException(ACCESS_TOKEN_EXPIRED, "Access Token expired");
            }
            return Long.parseLong(extractField(jwsObject, USER_ID));
        } catch (ParseException | IllegalStateException | JOSEException ex) {
            log.error("Something go wrong in jwt", ex);
            throw new AuthException("auth.validate-jwt-exception", ex.getMessage());
        }
    }

    @Override
    public RefreshTokenDto validateRefreshToken(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier verifier = new RSASSAVerifier(rsaJWK.toPublicJWK());
            if (!jwsObject.verify(verifier)) {
                throw new AuthException("auth.invalid-token", "Token not valid");
            }
            ActiveRefreshTokenEntity entity =
                    activeRefreshTokenRepository.findByUuid(extractField(jwsObject, UUID))
                            .orElseThrow(() -> new AuthException(REFRESH_TOKEN_EXPIRED, "Refresh Token expired"));
            RefreshTokenDto dto = getRefreshTokenDto(jwsObject);
            if (dto.getExpirationTime().isBefore(LocalDateTime.now()) || dto.getCount() <= 0) {
                throw new AuthException(REFRESH_TOKEN_EXPIRED, "Refresh Token expired");
            }
            activeRefreshTokenRepository.delete(entity);
            return dto;
        } catch (ParseException | IllegalStateException | JOSEException ex) {
            log.error("Something go wrong in jwt", ex);
            throw new AuthException("auth.validate-jwt-exception", ex.getMessage());
        }
    }

    private RefreshTokenDto getRefreshTokenDto(JWSObject jwsObject) {
        return RefreshTokenDto.builder()
                .userId(Long.parseLong(extractField(jwsObject, USER_ID)))
                .expirationTime(DateUtil.toLocalDateTime(extractField(jwsObject, EXPIRATION_TIME)))
                .count(Integer.parseInt(extractField(jwsObject, COUNT)) - 1)
                .build();
    }
}