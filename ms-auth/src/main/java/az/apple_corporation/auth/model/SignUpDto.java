package az.apple_corporation.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String salt;
    private String verifier;
}