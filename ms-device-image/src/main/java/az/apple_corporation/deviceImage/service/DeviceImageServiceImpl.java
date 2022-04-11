package az.apple_corporation.deviceImage.service;

import az.apple_corporation.deviceImage.dao.DeviceImageEntity;
import az.apple_corporation.deviceImage.dao.DeviceImageRepository;
import az.apple_corporation.deviceImage.mapper.DeviceImageMapper;
import az.apple_corporation.deviceImage.model.DeviceImageDto;
import az.apple_corporation.deviceImage.model.exception.ImageException;
import az.apple_corporation.deviceImage.util.DeviceImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static az.apple_corporation.deviceImage.model.Status.DELETED;

@Service
@Slf4j
public class DeviceImageServiceImpl implements DeviceImageService {
    private final DeviceImageRepository deviceImageRepository;
    private final DeviceImageUtil deviceImageUtil;

    public DeviceImageServiceImpl(DeviceImageRepository deviceImageRepository, DeviceImageUtil deviceImageUtil) {
        this.deviceImageRepository = deviceImageRepository;
        this.deviceImageUtil = deviceImageUtil;
    }

    @Override
    public Resource getImageByID(Long id) {
        DeviceImageEntity entity = deviceImageUtil.deviceImageExist(id);
        return new ByteArrayResource(entity.getImage());
    }

    @Override
    public List<DeviceImageDto> getDeviceImages() {
        List<DeviceImageDto> deviceImages = new ArrayList<>();
        deviceImageRepository.findAll().forEach(entity -> deviceImages.add(DeviceImageMapper.toDto(entity)));
        return deviceImages;
    }

    @Override
    public DeviceImageDto getDeviceImage(Long id) {
        DeviceImageEntity entity = deviceImageUtil.deviceImageExist(id);
        return DeviceImageMapper.toDto(entity);
    }

    @Override
    public Long addDeviceImage(String name, MultipartFile image) {
        DeviceImageEntity entity = new DeviceImageEntity();
        entity.setName(name);
        try {
            entity.setImage(image.getBytes());
        } catch (IOException ex) {
            log.error("Something went wrong in posting the file", ex);
            throw new ImageException("image.input-output-exception", ex.getMessage());
        }
        entity = deviceImageRepository.save(entity);
        return DeviceImageMapper.toDto(entity).getId();
    }

    @Override
    public Long updateDeviceImage(Long id, String name, MultipartFile image) {
        DeviceImageEntity entity = deviceImageUtil.deviceImageExist(id);
        DeviceImageMapper.toEntity(entity, name, image);
        entity = deviceImageRepository.save(entity);
        return DeviceImageMapper.toDto(entity).getId();
    }

    @Override
    public Long deleteDeviceImage(Long id) {
        DeviceImageEntity entity = deviceImageUtil.deviceImageExist(id);
        entity.setStatus(DELETED);
        entity = deviceImageRepository.save(entity);
        return DeviceImageMapper.toDto(entity).getId();
    }
}