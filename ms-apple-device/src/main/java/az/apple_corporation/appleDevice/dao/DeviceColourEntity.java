package az.apple_corporation.appleDevice.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "device_colours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceColourEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private DeviceEntity device;
    private String colour;
}