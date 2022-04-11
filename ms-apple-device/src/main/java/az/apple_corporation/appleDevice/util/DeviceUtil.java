package az.apple_corporation.appleDevice.util;

import az.apple_corporation.appleDevice.dao.DeviceEntity;
import az.apple_corporation.appleDevice.dao.DeviceRepository;
import az.apple_corporation.appleDevice.model.exception.DeviceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeviceUtil {
    private final DeviceRepository deviceRepository;

    public DeviceUtil(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceEntity deviceExist(Long id) {
        Optional<DeviceEntity> entityOptional = deviceRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new DeviceNotFoundException(id);
        }
        return entityOptional.get();
    }
}