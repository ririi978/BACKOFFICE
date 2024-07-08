package org.sid.msorder.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productName;

    @Column(length = 100)
    private String subTitle;

    @Column(length = 100)
    private String subMention;

    @Column(length = 50)
    private String familyName;

    @Column(length = 30)
    private String familyCode;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(precision = 10, scale = 2)
    private BigDecimal commissioningFees;

    @Column(precision = 10, scale = 2)
    private BigDecimal installationFees;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 50)
    private String engagementPeriod;


    // id referencing the existing product in catalog
    @Column
    private Long productId;

    @Column(length = 100)
    private String idPanel;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private Device device;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attribute> attributes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Order order;

}

