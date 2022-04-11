package az.apple_corporation.appleDevice.mapper;

import az.apple_corporation.appleDevice.dao.DeviceColourEntity;
import az.apple_corporation.appleDevice.dao.DeviceEntity;
import az.apple_corporation.appleDevice.model.DeviceColourDto;

import java.util.ArrayList;
import java.util.List;

public class DeviceColourMapper {
    public static List<DeviceColourDto> toDto(List<DeviceColourEntity> colours) {
        if (colours == null) {
            return null;
        }
        List<DeviceColourDto> result = new ArrayList<>();
        colours.forEach(c ->
                result.add(DeviceColourDto.builder()
                        .colour(c.getColour())
                        .build()
                )
        );
        return result;
    }

    public static List<DeviceColourEntity> toEntities(DeviceEntity entity, List<DeviceColourDto> colours) {
        if (colours == null) {
            return null;
        }
        List<DeviceColourEntity> result = new ArrayList<>();
        colours.forEach(c ->
                result.add(DeviceColourEntity.builder()
                        .colour(c.getColour())
                        .device(entity)
                        .build()
                )
        );
        return result;
    }
}