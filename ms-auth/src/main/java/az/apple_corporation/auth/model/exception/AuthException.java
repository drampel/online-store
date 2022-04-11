package az.apple_corporation.auth.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AuthException extends RuntimeException {
    private String code;

    public AuthException(String code, String message) {
        super(message);
        this.code = code;
    }
    public AuthException(String message) {
        super(message);
    }
}