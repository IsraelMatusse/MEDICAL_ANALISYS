package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;

import java.util.List;

public record ScreeningsByPatientDTO(
        String id,
        String name,
        String surname,
        String code,
        List<ScreeningResDto> screenings

) {
    public ScreeningsByPatientDTO(Patient patient, List<ScreeningResDto> screenings){
        this(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getCode(),
                screenings
        );
    }
}
