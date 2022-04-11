package az.apple_corporation.deviceImage.model.exception;

public class DeviceImageNotFoundException extends RuntimeException{
    public DeviceImageNotFoundException(Long id) {
        super(String.format("deviceImage with id %d not found", id));
    }
}