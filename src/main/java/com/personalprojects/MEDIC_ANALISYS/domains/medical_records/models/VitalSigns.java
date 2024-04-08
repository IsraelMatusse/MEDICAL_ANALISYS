package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "vital_signs")
public class VitalSigns {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private double  systolicAterialPressure;
    private double  diastolicAterialPressure;
    private double  heartRate;
    private double  respiratoryRate;
    private double  oxygenSaturation;
    private double  bodyTemperature;
    private Date  date = new Date();
    private Time  time= new Time(System.currentTimeMillis());

    public VitalSigns(ScreeningCreateDto screening){
        this.bodyTemperature=screening.bodyTemperature();
        this.heartRate=screening.heartRate();
        this.oxygenSaturation=screening.oxygenSaturation();
        this.respiratoryRate=screening.respiratoryRate();
        this.systolicAterialPressure=screening.sistolicAterialPressure();
        this.diastolicAterialPressure=screening.diastolicAterialPressure();
    }




}
