package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningCreateDto;
import com.personalprojects.MEDIC_ANALISYS.enums.BloodType;
import com.personalprojects.MEDIC_ANALISYS.enums.Genders;
import com.personalprojects.MEDIC_ANALISYS.enums.LevelUrgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "screening")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date date;
    @Column(name = "main_complaint")
    private String mainComplaint;
    private String urgency;
    @Column(columnDefinition = "TEXT")
    private String observations;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "vital_signs_id")
    private VitalSigns vitalSigns;

    public Screening(ScreeningCreateDto screeningCreateDto, Patient patient, VitalSigns vitalSigns, String urgency) {

        this.date = new Date();
        this.mainComplaint = screeningCreateDto.mainComplaint();
        this.urgency = urgency;
        this.observations = screeningCreateDto.obervations();
        this.patient = patient;
        this.vitalSigns = vitalSigns;
    }


}
