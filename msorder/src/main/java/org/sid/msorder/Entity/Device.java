package org.sid.msorder.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Device {
    @Id
    @SequenceGenerator(name = "DEVICE_GENERATOR", sequenceName = "DEVICE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_GENERATOR")
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 50)
    private String code;

    @Column(precision = 10, scale = 2)
    private BigDecimal provisionFees;


    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<DeviceCriteria> criteria = new ArrayList<>();

    @OneToOne(mappedBy = "device")
    private Product product;

}
