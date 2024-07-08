package org.sid.msproduct.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDeviceEngagement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany()
    private List<Device> devices;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EngagementDuration> engagement_durations;
}
