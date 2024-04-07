package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.controllers;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.CreatePatientDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services.PatientService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.ConflictException;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatentController {

    private final PatientService patientService;

    @Operation(description = "Criar um novo paciente")
    @PostMapping
    public ResponseEntity<ResponseAPI>createPatient(@RequestBody @Valid  CreatePatientDto patientDto) throws ConflictException {
        patientService.createPatient(patientDto);
        return ResponseEntity.ok(new ResponseAPI("Paciente criado com sucesso!", null));
    }

    @GetMapping
    @Operation(description = "Obter todos os pacientes")
    public ResponseEntity<ResponseAPI>getAllPatients(){
        return ResponseEntity.ok(new ResponseAPI("Pacientes do sistema !", patientService.findAll()));

    }

}
