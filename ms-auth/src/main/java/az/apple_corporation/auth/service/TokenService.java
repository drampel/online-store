package az.apple_corporation.auth.service;

import az.apple_corporation.auth.model.RefreshTokenDto;

public interface TokenService {
    String generateAccessToken(Long userId);

    String generateRefreshToken(RefreshTokenDto refreshTokenDto);

    Long validateAccessToken(String token);

    RefreshTokenDto validateRefreshToken(String token);
}