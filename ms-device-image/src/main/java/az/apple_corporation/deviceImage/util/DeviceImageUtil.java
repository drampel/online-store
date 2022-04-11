package az.apple_corporation.deviceImage.util;

import az.apple_corporation.deviceImage.dao.DeviceImageEntity;
import az.apple_corporation.deviceImage.dao.DeviceImageRepository;
import az.apple_corporation.deviceImage.model.exception.DeviceImageNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeviceImageUtil {
    private final DeviceImageRepository deviceImageRepository;

    public DeviceImageUtil(DeviceImageRepository deviceImageRepository) {
        this.deviceImageRepository = deviceImageRepository;
    }

    public DeviceImageEntity deviceImageExist(Long id) {
        Optional<DeviceImageEntity> entityOptional = deviceImageRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new DeviceImageNotFoundException(id);
        }
        return entityOptional.get();
    }
}