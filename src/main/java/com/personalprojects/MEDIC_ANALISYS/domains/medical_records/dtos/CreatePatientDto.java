package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CreatePatientDto(
    @NotBlank(message = "Insira o nome do paciente")
    String name,
    @NotBlank(message = "Insira o apelido do paciente")
    String surname,
    @NotBlank(message = "Insira o nome da mãe do paciente")
    String mothersName,
    @NotBlank(message = "Insira o nome do pai do paciente")
    String fathersName,
    @NotNull(message = "Insira a data de nascimento do paciente")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthDate,
    @NotBlank(message = "Insria o bairro do paciente")
    String neighboorHood,
    @NotBlank(message = "Insira o contaco do paciente")
    String msisdn,
    @NotBlank(message = "Insira o email do paciente")
    String email,
    @NotBlank(message = "Insira o numero da rua do paciente")
    String roadNumber,
    @NotBlank(message = "Insira o numero da casa do paciente")
    String houseNumber,
    @NotNull(message = "Insira a altura do paciente")
    float height,
    @NotNull(message = "Insira o peso do paciente")
    float weight,
    String documentNumber


) {
}
