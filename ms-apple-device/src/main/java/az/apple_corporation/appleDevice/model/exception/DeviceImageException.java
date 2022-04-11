package az.apple_corporation.appleDevice.model.exception;

public class DeviceImageException extends RuntimeException {
    public DeviceImageException(Long id) {
        super(String.format("Images with device id %d not found", id));
    }

    public DeviceImageException(String message) {
        super(message);
    }
}