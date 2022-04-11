package az.apple_corporation.appleDevice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class DeviceListener {
    private static DeviceHistoryRepository deviceHistoryRepository;

    @Autowired
    public void init(DeviceHistoryRepository deviceHistoryRepository) {
        DeviceListener.deviceHistoryRepository = deviceHistoryRepository;
    }

    @PostUpdate
    @PostPersist
    public void saveDeviceSpecificationsChanges(DeviceEntity entity) {
        deviceHistoryRepository.save(entity.toDeviceHistoryEntity());
    }
}