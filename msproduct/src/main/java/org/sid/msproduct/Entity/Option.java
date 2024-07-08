package org.sid.msproduct.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String icon;
    private String title;
    private String description;
    private int price;
    private Boolean enabled;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
