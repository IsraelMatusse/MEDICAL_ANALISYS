package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record VitalSignsRegisterDto(
        @Min(value = 50, message = "A pressão sistolica deve ser entre 50 e 250")
        @Max(value = 250, message = "A pressão sistolica deve ser entre 50 e 250")
        double sistolicAterialPressure,
        @Min(value = 30, message = "A pressão diastolica deve ser entre 30 e 150")
        @Max(value = 150, message = "A pressão diastolica deve ser entre 30 e 150")
        double diastolicAterialPressure,
        @Min(value = 30, message = "A frequência cardiaca deve ser entre 30 e 200")
        @Max(value = 200, message = "A frequência cardiaca deve ser entre 30 e 200")
        double heartRate,
        @Min(value = 5, message = "A frquência respiratoria deve ser entre 5 e 50")
        @Max(value = 50, message = "A frquência respiratoria deve ser entre 5 e 50")
        double respiratoryRate,
        @Min(value = 50, message = "A saturação de oxigenio deve ser entre 50 e 100")
        @Max(value = 100, message = "A saturação de oxigenio deve ser entre 50 e 100")
        double oxygenSaturation,
        @Min(value = 30, message = "A temperatura corporal deve ser entre 30 e 43")
        @Max(value = 43, message = "A temperatura corporal deve ser entre 30 e 43")
        double bodyTemperature
) {
}
