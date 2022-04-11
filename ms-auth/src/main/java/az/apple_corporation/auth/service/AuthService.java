package az.apple_corporation.auth.service;

import az.apple_corporation.auth.model.SignUpDto;
import az.apple_corporation.auth.model.SrpStep1RequestDto;
import az.apple_corporation.auth.model.SrpStep1ResponseDto;
import az.apple_corporation.auth.model.SrpStep2RequestDto;
import az.apple_corporation.auth.model.SrpStep2ResponseDto;
import az.apple_corporation.auth.model.TokenPair;
import org.springframework.data.util.Pair;

public interface AuthService {
    void signUp(SignUpDto signUpDto);

    SignUpDto getUserByEmail(String email);

    SrpStep1ResponseDto step1(SrpStep1RequestDto srpStep1RequestDto);

    Pair<SrpStep2ResponseDto, TokenPair> step2(SrpStep2RequestDto srpStep2RequestDto);

    Long validateAccessToken(String accessToken);

    TokenPair refreshTokens(String refreshToken);
}