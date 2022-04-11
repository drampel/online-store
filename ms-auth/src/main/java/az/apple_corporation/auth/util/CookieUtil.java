package az.apple_corporation.auth.util;

import az.apple_corporation.auth.model.TokenPair;
import az.apple_corporation.auth.model.constants.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class CookieUtil {
    public void addCookies(TokenPair tokens, HttpServletResponse response) {
        addCookie(HttpHeaders.ACCESS_TOKEN, tokens.getAccessToken(), response);
        addCookie(HttpHeaders.REFRESH_TOKEN, tokens.getRefreshToken(), response);
    }

    private void addCookie(String name, String value, HttpServletResponse response) {
        final ResponseCookie responseCookie = ResponseCookie
                .from(name, value)
//                .secure(true)
//                .httpOnly(true)
                .path("/")
//                .sameSite("Strict")
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
    }
}