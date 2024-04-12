package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.controllers;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.CreatePatientDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services.PatientService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.ConflictException;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Pacientes")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatentController {

    private final PatientService patientService;

    @Operation(summary = "Realiza criacção de paciente", description = "Realiza criacção de paciente")
    @PostMapping
    public ResponseEntity<ResponseAPI>createPatient(@RequestBody @Valid  CreatePatientDto patientDto) throws ConflictException {
        patientService.createPatient(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Paciente criado com sucesso!", null));
    }

    @GetMapping
    @Operation(summary = "Realiza busca de pacientes por parametros", description = "Realiza busca de pacientes por parametros")
    public ResponseEntity<ResponseAPI>getParentsByParams(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "document-number", required = false) String documentNumber,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "blood-type", required = false) String bloodType,
            @RequestParam(value = "msisdn", required = false) String msisdn,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "id", required = false) String id) {

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseAPI("Pacientes do sistema !", patientService.getPatientByParamns(id, code, name, surname, msisdn, documentNumber, gender, bloodType)));
    }
}
