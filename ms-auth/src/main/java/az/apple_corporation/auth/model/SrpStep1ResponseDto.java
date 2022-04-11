package az.apple_corporation.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SrpStep1ResponseDto {
    private String salt;
    private String B;
}