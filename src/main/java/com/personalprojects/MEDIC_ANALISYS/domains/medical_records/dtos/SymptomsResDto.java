package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Symptoms;

import java.util.Date;

public record SymptomsResDto(

        String id,
        String description,
        String simptomIntensity,
        int duration,
        Date date
) {
    public SymptomsResDto(Symptoms symptoms){
        this(
                symptoms.getId(),
                symptoms.getDescription(),
                symptoms.getSimptomIntensity(),
                symptoms.getDuration(),
                symptoms.getCreatedAt()
        );
    }
}
