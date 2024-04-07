package com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "outbreaks")
public class OutBreak {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer totalCases;
    private Integer totalDeaths;
    private Integer totalRecoveries;
    @ManyToOne
    private Strains strain;

}
