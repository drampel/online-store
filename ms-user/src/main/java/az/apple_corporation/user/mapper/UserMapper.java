package az.apple_corporation.user.mapper;

import az.apple_corporation.user.dao.UserEntity;
import az.apple_corporation.user.model.UserDto;

import static az.apple_corporation.user.model.Status.DELETED;

public class UserMapper {
    public static UserDto toDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .mobileNumber(entity.getMobileNumber())
                .email(entity.getEmail())
                .salt(entity.getSalt())
                .verifier(entity.getVerifier())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static UserEntity toEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mobileNumber(dto.getMobileNumber())
                .email(dto.getEmail())
                .salt(dto.getSalt())
                .verifier(dto.getVerifier())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    public static void toEntity(UserDto dto, UserEntity entity) {
        if (dto.getFirstName() != null) entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) entity.setLastName(dto.getLastName());
        if (dto.getMobileNumber() != null) entity.setMobileNumber(dto.getMobileNumber());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getSalt() != null) entity.setSalt(dto.getSalt());
        if (dto.getVerifier() != null) entity.setVerifier(dto.getVerifier());
        if (dto.getStatus() != null && dto.getStatus() != DELETED) entity.setStatus(dto.getStatus());
    }
}