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
public class Option {
    @Id
    @SequenceGenerator(name = "OPTION_GENERATOR", sequenceName = "OPTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPTION_GENERATOR")
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 256)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne
    private Product product;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL)
    private List<Portability> porta = new ArrayList<>();
}

