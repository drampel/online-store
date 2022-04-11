package az.apple_corporation.appleDevice.model.exception;

public class DeviceColorsNotFoundException extends RuntimeException {
    public DeviceColorsNotFoundException(Long id) {
        super(String.format("Colors with device id %d not found", id));
    }
}