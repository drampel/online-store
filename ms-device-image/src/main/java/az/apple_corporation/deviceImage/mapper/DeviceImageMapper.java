package az.apple_corporation.deviceImage.mapper;

import az.apple_corporation.deviceImage.dao.DeviceImageEntity;
import az.apple_corporation.deviceImage.model.DeviceImageDto;
import az.apple_corporation.deviceImage.model.exception.ImageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class DeviceImageMapper {
    public static DeviceImageDto toDto(DeviceImageEntity entity) {
        return DeviceImageDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .image(entity.getImage())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static DeviceImageEntity toEntity(DeviceImageDto dto) {
        return DeviceImageEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .image(dto.getImage())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    public static void toEntity(DeviceImageEntity entity, String name, MultipartFile image) {
        if (name != null) entity.setName(name);
        if (image != null) {
            try {
                entity.setImage(image.getBytes());
            } catch (IOException ex) {
                log.error("Something went wrong in posting the file", ex);
                throw new ImageException("image.input-output-exception", ex.getMessage());
            }
        }
    }
}