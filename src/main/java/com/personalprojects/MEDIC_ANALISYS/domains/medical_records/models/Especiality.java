package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "especialities")
public class Especiality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private boolean status;
    @Column(name = "created_at")
    private Date createdAt;
}
