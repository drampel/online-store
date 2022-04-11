package az.apple_corporation.auth.controller;

import az.apple_corporation.auth.model.SignUpDto;
import az.apple_corporation.auth.model.SrpStep1RequestDto;
import az.apple_corporation.auth.model.SrpStep1ResponseDto;
import az.apple_corporation.auth.model.SrpStep2RequestDto;
import az.apple_corporation.auth.model.SrpStep2ResponseDto;
import az.apple_corporation.auth.model.TokenPair;
import az.apple_corporation.auth.model.constants.HttpHeaders;
import az.apple_corporation.auth.service.AuthService;
import az.apple_corporation.auth.util.CookieUtil;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.FOUND;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class AuthController {
    private final AuthService authService;
    private final CookieUtil cookieUtil;

    public AuthController(AuthService authService, CookieUtil cookieUtil) {
        this.authService = authService;
        this.cookieUtil = cookieUtil;
    }

    @PostMapping("sign-up")
    public void signUp(@RequestBody SignUpDto signUpDto) {
        authService.signUp(signUpDto);
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<SignUpDto> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(authService.getUserByEmail(email), FOUND);
    }

    @PostMapping("/srp/step1")
    public SrpStep1ResponseDto step1(@RequestBody SrpStep1RequestDto step1RequestDto) {
        return authService.step1(step1RequestDto);
    }

    @PostMapping("/srp/step2")
    public SrpStep2ResponseDto step2(@RequestBody SrpStep2RequestDto step2RequestDto,
                                     HttpServletResponse response) {
        Pair<SrpStep2ResponseDto, TokenPair> pair = authService.step2(step2RequestDto);
        cookieUtil.addCookies(pair.getSecond(), response);
        return pair.getFirst();
    }

    @PostMapping("/token/access")
    public void validateAccessToken(@CookieValue(name = HttpHeaders.ACCESS_TOKEN) String accessToken,
                                    HttpServletResponse response) {
        Long userId = authService.validateAccessToken(accessToken);
        response.addHeader(HttpHeaders.USER_ID, userId.toString());
    }

    @PostMapping("/token/refresh")
    public void refreshTokens(@CookieValue(name = HttpHeaders.REFRESH_TOKEN) String refreshToken,
                              HttpServletResponse response) {
        cookieUtil.addCookies(authService.refreshTokens(refreshToken), response);
    }
}