package az.apple_corporation.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenDto {
    private Long userId;
    private int count;
    private LocalDateTime expirationTime;
}