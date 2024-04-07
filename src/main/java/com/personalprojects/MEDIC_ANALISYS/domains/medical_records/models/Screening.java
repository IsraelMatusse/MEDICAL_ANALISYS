package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.enums.LevelUrgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "screenings")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date date;
    private String mainComplaint;
    @Enumerated(EnumType.STRING)
    private LevelUrgency urgency;
    @Column(columnDefinition = "TEXT")
    private String obervations;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private VitalSigns vitalSigns;

}
