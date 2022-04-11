package az.apple_corporation.appleDevice.client;

import az.apple_corporation.appleDevice.model.image.DeviceImageDto;

public interface DeviceImage {
    DeviceImageDto getDeviceImage(Long id);
}