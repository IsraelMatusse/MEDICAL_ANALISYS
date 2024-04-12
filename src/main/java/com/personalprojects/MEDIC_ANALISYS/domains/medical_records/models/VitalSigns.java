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
    @Column(name = "systolic_arterial_pressure")
    private double  systolicAterialPressure;
    @Column(name = "diastolic_arterial_pressure")
    private double  diastolicAterialPressure;
    @Column(name = "heart_rate")
    private double  heartRate;
    @Column(name = "respiratory_rate")
    private double  respiratoryRate;
    @Column(name = "oxygen_saturation")
    private double  oxygenSaturation;
    @Column(name = "body_temperature")
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
