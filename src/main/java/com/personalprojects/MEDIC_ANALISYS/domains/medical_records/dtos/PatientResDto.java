package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;

import java.util.Date;

public record PatientResDto(
        String id,
        String code,
        String fullName,
        String mothersName,
        String fathersName,
        String neighboorHood,
        String msisdn,
        String email,
        String road,
        String houseNr,
        String gender,
        String bloodType,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        Date birthDate,
        String province,
        String district
) {

    public PatientResDto(Patient patient, String province, String district){
        this(
                patient.getId(),
                patient.getCode(),
                patient.getName() +" "+ patient.getSurname(),
                patient.getMothersName(),
                patient.getFathersName(),
                patient.getNeighboorHood(),
                patient.getMsisdn(),
                patient.getEmail(),
                patient.getRoad(),
                patient.getHouseNr(),
                patient.getGender(),
                patient.getBloodType(),
                patient.getBirthDate(),
                province,
                district
        );
    }
}
