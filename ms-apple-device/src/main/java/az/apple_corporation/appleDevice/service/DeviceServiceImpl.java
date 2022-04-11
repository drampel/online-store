package az.apple_corporation.appleDevice.service;

import az.apple_corporation.appleDevice.client.DeviceImage;
import az.apple_corporation.appleDevice.dao.DeviceEntity;
import az.apple_corporation.appleDevice.dao.DeviceRepository;
import az.apple_corporation.appleDevice.mapper.DeviceColourMapper;
import az.apple_corporation.appleDevice.mapper.DeviceMapper;
import az.apple_corporation.appleDevice.mapper.DeviceSpecificationsMapper;
import az.apple_corporation.appleDevice.model.DeviceColourDto;
import az.apple_corporation.appleDevice.model.DeviceDto;
import az.apple_corporation.appleDevice.model.SpecificationType;
import az.apple_corporation.appleDevice.model.exception.DeviceColorsNotFoundException;
import az.apple_corporation.appleDevice.model.exception.DeviceImageException;
import az.apple_corporation.appleDevice.model.exception.DeviceSpecificationsNotFoundException;
import az.apple_corporation.appleDevice.model.image.DeviceImageDto;
import az.apple_corporation.appleDevice.util.DeviceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static az.apple_corporation.appleDevice.model.Status.DELETED;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceUtil deviceUtil;
    private final DeviceImage deviceImage;

    public DeviceServiceImpl(DeviceRepository deviceRepository, DeviceUtil deviceUtil, DeviceImage deviceImage) {
        this.deviceRepository = deviceRepository;
        this.deviceUtil = deviceUtil;
        this.deviceImage = deviceImage;
    }

    @Override
    public List<DeviceDto> getAllDevices() {
        List<DeviceDto> devices = new ArrayList<>();
        deviceRepository.findAll().forEach(entity -> {
            List<byte[]> deviceImages = new ArrayList<>();
            for (Long imageId : entity.getImageIds()) {
                DeviceImageDto deviceImageDto = deviceImage.getDeviceImage(imageId);
                deviceImages.add(deviceImageDto.getImage());
            }
            devices.add(DeviceMapper.toDto(entity, deviceImages));
            log.info(String.valueOf(deviceImages.size()));
        });
        return devices;
    }

    @Override
    public DeviceDto getDevice(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        List<byte[]> deviceImages = new ArrayList<>();
        for (Long imageId : entity.getImageIds()) {
            DeviceImageDto deviceImageDto = deviceImage.getDeviceImage(imageId);
            deviceImages.add(deviceImageDto.getImage());
        }
        log.info(String.valueOf(deviceImages.size()));
        return DeviceMapper.toDto(entity, deviceImages);
    }

    @Override
    public DeviceDto addDevice(DeviceDto dto) {
        List<String> imageNames = new ArrayList<>();
        if (dto.getImageIds() != null) {
            for (Long imageId : dto.getImageIds()) {
                DeviceImageDto deviceImageDto = deviceImage.getDeviceImage(imageId);
                imageNames.add(deviceImageDto.getName());
            }
        }
        DeviceEntity entity = deviceRepository.save(DeviceMapper.toEntity(dto, imageNames));
        return DeviceMapper.toDto(entity);
    }

    @Override
    public DeviceDto updateDevice(DeviceDto dto) {
        DeviceEntity entity = deviceUtil.deviceExist(dto.getId());
        List<String> imageNames = new ArrayList<>();
        if (dto.getImageIds() != null) {
            for (Long imageId : dto.getImageIds()) {
                DeviceImageDto deviceImageDto = deviceImage.getDeviceImage(imageId);
                imageNames.add(deviceImageDto.getName());
            }
        }
        DeviceMapper.toEntity(dto, entity, imageNames);
        entity = deviceRepository.save(entity);
        return DeviceMapper.toDto(entity);
    }

    @Override
    public DeviceDto deleteDevice(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        entity.setStatus(DELETED);
        deviceRepository.save(entity);
        return DeviceMapper.toDto(entity);
    }

    @Override
    public List<DeviceColourDto> getColorsByDeviceId(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getColours().isEmpty()) throw new DeviceColorsNotFoundException(entity.getId());
        return DeviceColourMapper.toDto(entity.getColours());
    }

    @Override
    public void deleteColorsByDeviceId(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getColours().isEmpty()) throw new DeviceColorsNotFoundException(entity.getId());
        entity.getColours().clear();
        deviceRepository.save(entity);
    }

    @Override
    public Map<SpecificationType, String> getSpecificationsByDeviceId(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getSpecifications().isEmpty()) throw new DeviceSpecificationsNotFoundException(entity.getId());
        return DeviceSpecificationsMapper.toDto(entity.getSpecifications());
    }

    @Override
    public void deleteSpecificationsByDeviceId(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getSpecifications().isEmpty()) throw new DeviceSpecificationsNotFoundException(entity.getId());
        entity.getSpecifications().clear();
        deviceRepository.save(entity);
    }

    @Override
    public List<DeviceImageDto> getImagesByDeviceId(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getImageIds().isEmpty())
            throw new DeviceImageException(entity.getId());
        List<DeviceImageDto> deviceImages = new ArrayList<>();
        for (Long imageId : entity.getImageIds()) {
            DeviceImageDto deviceImageDto = deviceImage.getDeviceImage(imageId);
            deviceImages.add(deviceImageDto);
        }
        return deviceImages;
    }

    @Override
    public Resource getImageByDeviceId(Long id, Long imageId) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getImageIds().isEmpty())
            throw new DeviceImageException(entity.getId());
        byte[] image = new byte[0];
        for (Long deviceImageId : entity.getImageIds()) {
            if (deviceImageId.equals(imageId)) {
                DeviceImageDto deviceImageDto = deviceImage.getDeviceImage(imageId);
                image = deviceImageDto.getImage();
                break;
            }
        }
        if (Arrays.equals(image, new byte[0]))
            throw new DeviceImageException(String.format("Image with id %d not found", id));
        return new ByteArrayResource(image);
    }

    @Override
    public void deleteImagesByDeviceId(Long id) {
        DeviceEntity entity = deviceUtil.deviceExist(id);
        if (entity.getImageIds().isEmpty()) throw new DeviceImageException(entity.getId());
        entity.getImageIds().clear();
        entity.getImageNames().clear();
        deviceRepository.save(entity);
    }
}