package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "symptoms")
public class Symptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    @ManyToOne
    private Screening screening;
}
