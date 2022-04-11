package az.apple_corporation.deviceImage.dao;

import az.apple_corporation.deviceImage.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "device_image_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceImageHistoryEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private DeviceImageEntity deviceImage;
    private String name;
    @Lob
    @Basic(fetch = LAZY)
    private byte[] image;
    @Enumerated(STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}