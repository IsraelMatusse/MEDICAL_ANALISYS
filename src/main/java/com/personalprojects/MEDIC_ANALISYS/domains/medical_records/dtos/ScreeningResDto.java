package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public record ScreeningResDto(
    String id,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date screeningDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    LocalTime screeningTime,
    String mainComplaint,
    String urgency,
    String observations,
    PatientResponseDto patient,
    VitalSignsResDto vitalSigns,
    List<SymptomsResDto>symptoms
) {

    public ScreeningResDto(Screening screening, PatientResponseDto patient, VitalSignsResDto vitalSigns,   List<SymptomsResDto>symptoms){
        this(
                screening.getId(),
                screening.getScreeningDate(),
                Instant.ofEpochMilli(screening.getScreeningDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalTime(),
                screening.getMainComplaint(),
                screening.getUrgency(),
                screening.getObservations(),
                patient,
                vitalSigns,
                symptoms
        );
    }
}
