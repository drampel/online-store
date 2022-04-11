package az.apple_corporation.appleDevice.mapper;

import az.apple_corporation.appleDevice.dao.DeviceEntity;
import az.apple_corporation.appleDevice.model.DeviceDto;

import java.util.List;

public class DeviceMapper {
    public static DeviceDto toDto(DeviceEntity entity) {
        DeviceDto dto = DeviceDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .imageIds(entity.getImageIds())
                .imageNames(entity.getImageNames())
                .build();
        dto.setColours(DeviceColourMapper.toDto(entity.getColours()));
        dto.setSpecifications(DeviceSpecificationsMapper.toDto(entity.getSpecifications()));
        return dto;
    }

    public static DeviceDto toDto(DeviceEntity entity, List<byte[]> images) {
        DeviceDto dto = DeviceDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .imageIds(entity.getImageIds())
                .imageNames(entity.getImageNames())
                .images(images)
                .build();
        dto.setColours(DeviceColourMapper.toDto(entity.getColours()));
        dto.setSpecifications(DeviceSpecificationsMapper.toDto(entity.getSpecifications()));
        return dto;
    }

    public static DeviceEntity toEntity(DeviceDto dto, List<String> imageNames) {
        DeviceEntity entity = DeviceEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .imageIds(dto.getImageIds())
                .imageNames(imageNames)
                .build();
        entity.setColours(DeviceColourMapper.toEntities(entity, dto.getColours()));
        entity.setSpecifications(DeviceSpecificationsMapper.toEntities(entity, dto.getSpecifications()));
        return entity;
    }

    public static void toEntity(DeviceDto dto, DeviceEntity entity, List<String> imageNames) {
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getPrice() != null) entity.setPrice(dto.getPrice());
        if (dto.getColours() != null) {
            entity.getColours().clear();
            entity.getColours().addAll(
                    DeviceColourMapper.toEntities(entity, dto.getColours()));
        }
        if (dto.getSpecifications() != null) entity.getSpecifications().addAll(
                DeviceSpecificationsMapper.toEntities(entity, dto.getSpecifications()));
        if (dto.getImageIds() != null) {
            entity.setImageIds(dto.getImageIds());
            entity.setImageNames(imageNames);
        }
    }
}