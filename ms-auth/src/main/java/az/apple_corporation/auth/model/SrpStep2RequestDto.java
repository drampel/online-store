package az.apple_corporation.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SrpStep2RequestDto {
    private String email;
    private String A;
    private String M1;
}