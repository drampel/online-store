package az.apple_corporation.deviceImage.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class DeviceImageDto {
    private Long id;
    private String name;
    private byte[] image;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}