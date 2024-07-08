package org.sid.msorder.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100)
    private String rs;

    @Column(length = 100)
    private String rc;

    @Column(length = 20)
    private String ice;

    @Column(length = 50)
    private String city;


    @Column
    private String billingAddress;

    @Column(length = 50)
    private String identityNumber;


    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 30)
    private String cin;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phoneNumber;


    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Order> orders = new ArrayList<>();

    public Client(Long id) {
        this.id = id;
    }
}
