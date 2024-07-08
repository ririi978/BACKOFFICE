package org.sid.msproduct.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String icon;
    private String description;
    private Boolean enabled;
    private String code;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @OneToMany (cascade=CascadeType.ALL,orphanRemoval = true)
    private List<DeviceCriteria> device_criterias;


}

