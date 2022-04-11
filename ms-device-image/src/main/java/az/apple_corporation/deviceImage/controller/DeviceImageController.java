package az.apple_corporation.deviceImage.controller;

import az.apple_corporation.deviceImage.model.DeviceImageDto;
import az.apple_corporation.deviceImage.service.DeviceImageService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/device_images")
@Slf4j
public class DeviceImageController {
    private final DeviceImageService deviceImageService;

    public DeviceImageController(DeviceImageService deviceImageService) {
        this.deviceImageService = deviceImageService;
    }

    @GetMapping(path = "/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImageByID(@PathVariable Long id) {
        return new ResponseEntity<>(deviceImageService.getImageByID(id), FOUND);
    }

    @GetMapping
    public ResponseEntity<List<DeviceImageDto>> getDeviceImages() {
        return new ResponseEntity<>(deviceImageService.getDeviceImages(), FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeviceImageDto> getDeviceImage(@PathVariable Long id) {
        return new ResponseEntity<>(deviceImageService.getDeviceImage(id), FOUND);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Long> addDeviceImage(@RequestPart String name,
                                               @RequestPart MultipartFile image) {
        return new ResponseEntity<>(deviceImageService.addDeviceImage(name, image), CREATED);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Long> updateDeviceImage(@PathVariable Long id,
                                                  @RequestPart(required = false) String name,
                                                  @RequestPart(required = false) MultipartFile image) {
        return new ResponseEntity<>(deviceImageService.updateDeviceImage(id, name, image), OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteDeviceImage(@PathVariable Long id) {
        return new ResponseEntity<>(deviceImageService.deleteDeviceImage(id), OK);
    }
}