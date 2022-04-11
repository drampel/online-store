package az.apple_corporation.appleDevice.service;

import az.apple_corporation.appleDevice.model.DeviceColourDto;
import az.apple_corporation.appleDevice.model.DeviceDto;
import az.apple_corporation.appleDevice.model.SpecificationType;
import az.apple_corporation.appleDevice.model.image.DeviceImageDto;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    List<DeviceDto> getAllDevices();

    DeviceDto getDevice(Long id);

    DeviceDto addDevice(DeviceDto dto);

    DeviceDto updateDevice(DeviceDto dto);

    DeviceDto deleteDevice(Long id);

    List<DeviceColourDto> getColorsByDeviceId(Long id);

    void deleteColorsByDeviceId(Long id);

    Map<SpecificationType, String> getSpecificationsByDeviceId(Long id);

    void deleteSpecificationsByDeviceId(Long id);

    List<DeviceImageDto> getImagesByDeviceId(Long id);

    Resource getImageByDeviceId(Long id, Long imageId);

    void deleteImagesByDeviceId(Long id);
}