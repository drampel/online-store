package az.apple_corporation.appleDevice.model.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceImageDto {
    private Long id;
    private String name;
    private byte[] image;
}