package az.apple_corporation.appleDevice.model.exception;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(Long id) {
        super(String.format("Device with id %d not found", id));
    }
}