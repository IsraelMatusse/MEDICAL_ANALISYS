package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;

public record PatientResponseDto(
    String id,
    String name,
    String surname,
    String code

) {

    public PatientResponseDto(Patient patient){
        this(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getCode()
        );
    }
}
