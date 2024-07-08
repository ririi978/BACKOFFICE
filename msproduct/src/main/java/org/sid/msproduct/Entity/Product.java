package org.sid.msproduct.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String sub_title;
    private String sub_mention;
    private BigDecimal price;
    private BigDecimal fms;
    private BigDecimal fmd;
    private BigDecimal installation_fees;
    private Boolean enabled;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne()
    private Family family;
    @OneToMany()
    private List<Option> options;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Attribute> attributes;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductDeviceEngagement product_device_engagement;
}
