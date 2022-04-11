package az.apple_corporation.deviceImage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class DeviceImageListener {
    private static DeviceImageHistoryRepository deviceImageHistoryRepository;

    @Autowired
    public void init(DeviceImageHistoryRepository deviceImageHistoryRepository) {
        DeviceImageListener.deviceImageHistoryRepository = deviceImageHistoryRepository;
    }

    @PostUpdate
    @PostPersist
    public void saveDeviceImageChanges(DeviceImageEntity entity) {
        deviceImageHistoryRepository.save(entity.toDeviceImageHistoryEntity());
    }
}