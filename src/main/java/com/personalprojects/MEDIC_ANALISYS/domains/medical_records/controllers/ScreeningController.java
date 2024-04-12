package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.controllers;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningCreateDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services.ScreeningService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Table(name = "Triagens")
@RestController
@RequestMapping("/api/screenings")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;


    @Operation(summary = "Realiza criacão de triagem", description = "Realiza criacão de triagem")
    @PostMapping
    public ResponseEntity<ResponseAPI>createScreenings(@RequestBody ScreeningCreateDto screeningCreateDto) throws NotFoundException {
        screeningService.CreateScreening(screeningCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Triagem criada com sucesso!", null));
    }
}
