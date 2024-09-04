package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningRegisterDto;
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
    @Column(name = "screening_date")
    private Date screeningDate;
    @Column(columnDefinition = "TEXT", name = "main_complaint")
    private String mainComplaint;
    private String urgency;
    @Column(columnDefinition = "TEXT")
    private String observations;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "vital_signs_id")
    private VitalSigns vitalSigns;

    public Screening (ScreeningRegisterDto screeningData, Patient patient, VitalSigns vitalSigns){
        this.screeningDate=new Date();
        this.mainComplaint=screeningData.mainComplaint();
        this.urgency=screeningData.urgency();
        this.observations =screeningData.obervations();
        this.patient=patient;
        this.vitalSigns=vitalSigns;
    }

}
