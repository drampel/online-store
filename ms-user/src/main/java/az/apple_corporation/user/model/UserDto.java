package az.apple_corporation.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String salt;
    private String verifier;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}