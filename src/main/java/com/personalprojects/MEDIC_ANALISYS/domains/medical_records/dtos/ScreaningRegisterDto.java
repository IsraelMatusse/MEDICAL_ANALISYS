package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import java.util.List;

public record ScreaningRegisterDto(
        VitalSignsRegisterDto vitalSigns,
        List<SymptomsRegisterDto> symptoms,
        String mainComplaint,
        String patientCode,
        String urgency,
        String obervations

) {
}
