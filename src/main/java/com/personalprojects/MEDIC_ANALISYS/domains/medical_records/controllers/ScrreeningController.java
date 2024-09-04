package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.controllers;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningRegisterDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningResDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services.ScreeningService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
@Tag(name = "Triagem")
@RequiredArgsConstructor
public class ScrreeningController {

    private final ScreeningService screeningService;

    @PostMapping
    @Operation(summary = "Cria uma triagem")
    public ResponseEntity<ResponseAPI>createScreening(@RequestBody @Valid ScreeningRegisterDto screeningData) throws NotFoundException {
        screeningService.createScreening(screeningData);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Triagem criada com sucesso", null));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma triagem")
    public ResponseEntity<ScreeningResDto>findById(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(screeningService.findByIdRes(id));
    }

    @GetMapping
    @Operation(summary = "Retorna todas as triagens")
    public ResponseEntity<List<ScreeningResDto>>findAllScreenings(){
        return ResponseEntity.ok(screeningService.findAllScreenings());
    }
}
