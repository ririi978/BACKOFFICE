package org.sid.msproduct.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "device_criteria")
public class DeviceCriteria
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String icone;
    private String label;
    private String value;

}
