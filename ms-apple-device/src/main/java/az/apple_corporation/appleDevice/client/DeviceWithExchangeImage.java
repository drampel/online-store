package az.apple_corporation.appleDevice.client;

import az.apple_corporation.appleDevice.model.exception.DeviceImageException;
import az.apple_corporation.appleDevice.model.image.DeviceImageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class DeviceWithExchangeImage implements DeviceImage {
    private final RestTemplate restTemplate;
    private final String deviceImageUrl;

    public DeviceWithExchangeImage(RestTemplate restTemplate,
                                   @Value("${device.images.url}") String deviceImageUrl) {
        this.restTemplate = restTemplate;
        this.deviceImageUrl = deviceImageUrl;
    }

    @Override
    public DeviceImageDto getDeviceImage(Long id) {
        String url = String.format("%s/%d", deviceImageUrl, id);
        try {
            ResponseEntity<DeviceImageDto> responseEntity =
                    restTemplate.exchange(url,
                            GET,
                            null,
                            DeviceImageDto.class,
                            Long.toString(id));
            return responseEntity.getBody();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == NOT_FOUND) {
                throw new DeviceImageException(String.format("Image with id %d not found", id));
            } else {
                throw new DeviceImageException(String.format("Unexpected error occurred for image id %d", id));
            }
        }
    }
}