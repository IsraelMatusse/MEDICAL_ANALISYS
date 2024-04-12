package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.enums.LevelUrgency;

import java.util.List;

public record ScreeningCreateDto(
    String mainComplaint,
    LevelUrgency urgency,
    String obervations,
    String patientCode,
    double sistolicAterialPressure,
    double diastolicAterialPressure,
    double heartRate,
    double respiratoryRate,
    double oxygenSaturation,
    double bodyTemperature,
    List<SymptomsDto> symptoms

) {
}
