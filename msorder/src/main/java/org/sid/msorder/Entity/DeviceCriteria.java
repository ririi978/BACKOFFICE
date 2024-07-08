package org.sid.msorder.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeviceCriteria {
    @Id
    @SequenceGenerator(name = "DEVICE_CRITERIA_GENERATOR", sequenceName = "DEVICE_CRITERIA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_CRITERIA_GENERATOR")
    private Long id;

    @Column(length = 50)
    private String label;

    @Column(name = "`value`", length = 100)
    private String value;

    @ManyToOne
    private Device device;

}

