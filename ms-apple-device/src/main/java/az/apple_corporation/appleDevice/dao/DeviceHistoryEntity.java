package az.apple_corporation.appleDevice.dao;

import az.apple_corporation.appleDevice.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "device_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceHistoryEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private DeviceEntity device;
    private String name;
    private BigDecimal price;
    @Enumerated(STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
