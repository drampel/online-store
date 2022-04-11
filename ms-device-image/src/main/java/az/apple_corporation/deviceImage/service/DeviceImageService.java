package az.apple_corporation.deviceImage.service;

import az.apple_corporation.deviceImage.model.DeviceImageDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DeviceImageService {
    Resource getImageByID(Long id);

    List<DeviceImageDto> getDeviceImages();

    DeviceImageDto getDeviceImage(Long id);

    Long addDeviceImage(String name, MultipartFile image);

    Long updateDeviceImage(Long id, String name, MultipartFile image);

    Long deleteDeviceImage(Long id);
}