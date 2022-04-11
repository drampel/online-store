package az.apple_corporation.appleDevice.dao;

import az.apple_corporation.appleDevice.model.SpecificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "device_specifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceSpecificationEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private DeviceEntity device;
    @Enumerated(EnumType.STRING)
    private SpecificationType type;
    private String value;
}