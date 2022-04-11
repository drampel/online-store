package az.apple_corporation.auth.mapper;

import az.apple_corporation.auth.dao.AuthUserEntity;
import az.apple_corporation.auth.model.SignUpDto;

public class AuthMapper {

    public static AuthUserEntity toEntity(SignUpDto dto) {
        return AuthUserEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mobileNumber(dto.getMobileNumber())
                .email(dto.getEmail())
                .salt(dto.getSalt())
                .verifier(dto.getVerifier())
                .build();
    }

    public static SignUpDto toDto(AuthUserEntity entity) {
        return SignUpDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .mobileNumber(entity.getMobileNumber())
                .email(entity.getEmail())
                .build();
    }
}