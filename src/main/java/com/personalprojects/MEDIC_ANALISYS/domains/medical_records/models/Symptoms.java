package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.SymptomsRegisterDto;
import com.personalprojects.MEDIC_ANALISYS.enums.SimptomIntensity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "symptoms")
public class Symptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "simptom_intensity")
    private String simptomIntensity;
    private int duration;
    @ManyToOne
    @JoinColumn(name = "screenings_id")
    private Screening screening;
    @Column(name = "created_at")
    private Date createdAt;

    public Symptoms(SymptomsRegisterDto symptomsData, Screening screening){
        this.description=symptomsData.description();
        this.simptomIntensity=symptomsData.simptomIntensity();
        this.duration=symptomsData.duration();
        this.screening=screening;
        this.createdAt=new Date();
    }
}
