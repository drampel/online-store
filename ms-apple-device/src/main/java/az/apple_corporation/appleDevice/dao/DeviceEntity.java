package az.apple_corporation.appleDevice.dao;

import az.apple_corporation.appleDevice.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static az.apple_corporation.appleDevice.model.Status.ACTIVE;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "device")
@EntityListeners(DeviceListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "status != 'DELETED'")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Builder.Default
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DeviceColourEntity> colours = new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DeviceSpecificationEntity> specifications = new ArrayList<>();
    @Builder.Default
    @ElementCollection
    private List<Long> imageIds = new ArrayList<>();
    @Builder.Default
    @ElementCollection
    private List<String> imageNames = new ArrayList<>();
    @Enumerated(STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    DeviceHistoryEntity toDeviceHistoryEntity() {
        return DeviceHistoryEntity.builder()
                .device(this)
                .name(this.name)
                .price(this.price)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    @PrePersist
    void init() {
        this.status = ACTIVE;
    }
}