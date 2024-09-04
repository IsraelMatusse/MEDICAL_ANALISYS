package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.VitalSigns;

import java.util.Date;

public record VitalSignsResDto(
        String id,
        double  systolicAterialPressure,
        double  diastolicAterialPressure,
        double  heartRate,
        double  respiratoryRate,
        double  oxygenSaturation,
        double  bodyTemperature,
        Date createdAt
) {

    public VitalSignsResDto(VitalSigns vitalSigns){
        this(
                vitalSigns.getId(),
                vitalSigns.getSystolicAterialPressure(),
                vitalSigns.getDiastolicAterialPressure(),
                vitalSigns.getHeartRate(),
                vitalSigns.getRespiratoryRate(),
                vitalSigns.getOxygenSaturation(),
                vitalSigns.getBodyTemperature(),
                vitalSigns.getCreatedAt()
        );
    }
}
