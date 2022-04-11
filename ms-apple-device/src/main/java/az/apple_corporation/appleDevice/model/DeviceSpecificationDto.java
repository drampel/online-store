package az.apple_corporation.appleDevice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceSpecificationDto {
    private SpecificationType type;
    private String value;
}