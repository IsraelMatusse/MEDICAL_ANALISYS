package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.VitalSignsRegisterDto;
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
    private Date createdAt;

    public VitalSigns(VitalSignsRegisterDto vitalSignsData){
    this.systolicAterialPressure= vitalSignsData.diastolicAterialPressure();
    this.diastolicAterialPressure= vitalSignsData.diastolicAterialPressure();
    this.heartRate= vitalSignsData.heartRate();
    this.respiratoryRate= vitalSignsData.respiratoryRate();
    this.oxygenSaturation= vitalSignsData.oxygenSaturation();
    this.bodyTemperature= vitalSignsData.bodyTemperature();
    this.createdAt=new Date();
    }
}
