package org.sid.msorder.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String paymentMode;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @Column
    private String installationAddress;

    @Column
    private String deliveryAddress;

    @Column(length = 30)
    private String installationCity;

    @Column(length = 30)
    private String deliveryCity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();
}