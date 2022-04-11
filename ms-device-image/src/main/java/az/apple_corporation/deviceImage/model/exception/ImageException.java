package az.apple_corporation.deviceImage.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ImageException extends RuntimeException {
    private String code;

    public ImageException(String code, String message) {
        super(message);
        this.code = code;
    }
}