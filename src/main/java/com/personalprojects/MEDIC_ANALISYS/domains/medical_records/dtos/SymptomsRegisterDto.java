package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

public record SymptomsRegisterDto(
    String description,
    String simptomIntensity,
    int duration
) {
}
