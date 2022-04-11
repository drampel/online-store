package az.apple_corporation.appleDevice.controller;

import az.apple_corporation.appleDevice.model.DeviceColourDto;
import az.apple_corporation.appleDevice.model.DeviceDto;
import az.apple_corporation.appleDevice.model.SpecificationType;
import az.apple_corporation.appleDevice.model.image.DeviceImageDto;
import az.apple_corporation.appleDevice.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/devices")
@Slf4j
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> getAllDevices() {
        return new ResponseEntity<>(deviceService.getAllDevices(), FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeviceDto> getDevice(@PathVariable Long id) {
        return new ResponseEntity<>(deviceService.getDevice(id), FOUND);
    }

    @PostMapping
    public ResponseEntity<DeviceDto> addDevice(@RequestBody DeviceDto dto) {
        return new ResponseEntity<>(deviceService.addDevice(dto), CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable Long id,
                                                  @RequestBody DeviceDto dto) {
        dto.setId(id);
        return new ResponseEntity<>(deviceService.updateDevice(dto), OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeviceDto> deleteDevice(@PathVariable Long id) {
        return new ResponseEntity<>(deviceService.deleteDevice(id), OK);
    }

    @GetMapping(path = "/{id}/colors")
    public ResponseEntity<List<DeviceColourDto>> getColorsByDeviceId(@PathVariable Long id) {
        return new ResponseEntity<>(deviceService.getColorsByDeviceId(id), FOUND);
    }

    @DeleteMapping(path = "/{id}/colors")
    public void deleteColorsByDeviceId(@PathVariable Long id) {
        deviceService.deleteColorsByDeviceId(id);
    }

    @GetMapping(path = "/{id}/specifications")
    public ResponseEntity<Map<SpecificationType, String>> getSpecificationsByDeviceId(@PathVariable Long id) {
        return new ResponseEntity<>(deviceService.getSpecificationsByDeviceId(id), FOUND);
    }

    @DeleteMapping(path = "/{id}/specifications")
    public void deleteSpecificationsByDeviceId(@PathVariable Long id) {
        deviceService.deleteSpecificationsByDeviceId(id);
    }

    @GetMapping(path = "/{id}/images")
    public ResponseEntity<List<DeviceImageDto>> getImagesByDeviceId(@PathVariable Long id) {
        return new ResponseEntity<>(deviceService.getImagesByDeviceId(id), FOUND);
    }

    @GetMapping(path = "/{id}/images/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImageByDeviceId(@PathVariable Long id, @PathVariable Long imageId) {
        return new ResponseEntity<>(deviceService.getImageByDeviceId(id, imageId), FOUND);
    }

    @DeleteMapping(path = "/{id}/images")
    public void deleteImagesByDeviceId(@PathVariable Long id) {
        deviceService.deleteImagesByDeviceId(id);
    }
}