package org.sid.msproduct.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "Attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String icon;
    private String description;
    @Column(name = "value")
    private String value;
    private Integer position;
    private Boolean principal;

}