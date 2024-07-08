package org.sid.msorder.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    @Id
    @SequenceGenerator(name = "ATTRIBUTE_GENERATOR", sequenceName = "ATTRIBUTE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTRIBUTE_GENERATOR")
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 512)
    private String description;

    @Column(name = "`value`", length = 100)
    private String value;

    @ManyToOne
    private Product product;
}


