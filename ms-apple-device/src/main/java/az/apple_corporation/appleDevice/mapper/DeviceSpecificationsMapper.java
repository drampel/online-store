package az.apple_corporation.appleDevice.mapper;

import az.apple_corporation.appleDevice.dao.DeviceEntity;
import az.apple_corporation.appleDevice.dao.DeviceSpecificationEntity;
import az.apple_corporation.appleDevice.model.SpecificationType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DeviceSpecificationsMapper {
    public static Map<SpecificationType, String> toDto(List<DeviceSpecificationEntity> specifications) {
        if (specifications == null) {
            return null;
        }
        Map<SpecificationType, String> result = new LinkedHashMap<>();
        specifications.forEach(c ->
                result.put(c.getType(), c.getValue()));
        return result;
    }

    public static List<DeviceSpecificationEntity> toEntities(DeviceEntity entity,
                                                             Map<SpecificationType, String> specifications) {
        if (specifications == null) {
            return null;
        }
        List<DeviceSpecificationEntity> result = new ArrayList<>();
        specifications.forEach((k, v) ->
                result.add(DeviceSpecificationEntity.builder()
                        .type(k)
                        .value(v)
                        .device(entity)
                        .build()
                )
        );
        return result;
    }
}