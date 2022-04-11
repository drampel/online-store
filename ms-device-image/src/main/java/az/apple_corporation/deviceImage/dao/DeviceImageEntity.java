package az.apple_corporation.deviceImage.dao;

import az.apple_corporation.deviceImage.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static az.apple_corporation.deviceImage.model.Status.ACTIVE;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "device_image")
@EntityListeners(DeviceImageListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "status != 'DELETED'")
public class DeviceImageEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Basic(fetch = LAZY)
    private byte[] image;
    @Enumerated(STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    DeviceImageHistoryEntity toDeviceImageHistoryEntity() {
        return DeviceImageHistoryEntity.builder()
                .deviceImage(this)
                .name(this.name)
                .image(this.image)
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