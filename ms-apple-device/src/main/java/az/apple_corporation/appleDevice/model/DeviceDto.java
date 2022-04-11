package az.apple_corporation.appleDevice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private List<DeviceColourDto> colours;
    private Map<SpecificationType, String> specifications;
    private List<Long> imageIds;
    private List<String> imageNames;
    private List<byte[]> images;
}