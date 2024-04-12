package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ocupations")
public class Ocupation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
}
