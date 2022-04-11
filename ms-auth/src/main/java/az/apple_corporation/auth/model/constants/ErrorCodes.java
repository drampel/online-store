package az.apple_corporation.auth.model.constants;

public class ErrorCodes {
    public static final String REFRESH_TOKEN_EXPIRED = "auth.expired-refresh-exception";
    public static final String ACCESS_TOKEN_EXPIRED = "auth.expired-access-token";
    public static final String UNEXPECTED_EXCEPTION = "auth.unexpected-exception";

    private ErrorCodes() {
    }
}