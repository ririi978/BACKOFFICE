package org.sid.msorder.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Portability {
    @Id
    @SequenceGenerator(name = "PORTABILITY_GENERATOR", sequenceName = "PORTABILITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PORTABILITY_GENERATOR")
    private Long id;

    @Column(nullable = false, length = 10)
    private String operator;

    @Column(nullable = false, length = 20)
    private String mdn;

    @ManyToOne
    private Option option;
}