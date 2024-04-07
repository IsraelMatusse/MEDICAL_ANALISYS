package com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.models;

import com.personalprojects.MEDIC_ANALISYS.enums.PatogenicalType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "strains")
public class Strains {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private PatogenicalType patogenicalType;


}
