package az.apple_corporation.appleDevice.model.exception;

public class DeviceSpecificationsNotFoundException extends RuntimeException{
    public DeviceSpecificationsNotFoundException(Long id) {
        super(String.format("Specifications with device id %d not found", id));
    }
}