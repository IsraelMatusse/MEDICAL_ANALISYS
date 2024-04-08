package com.personalprojects.MEDIC_ANALISYS.domains.demography.models;

import com.personalprojects.MEDIC_ANALISYS.domains.SystemActions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "regional_zone")
@Data
public class RegionalZone extends SystemActions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String designation;

}