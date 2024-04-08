package com.personalprojects.MEDIC_ANALISYS.domains.demography.controllers;


import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.RegionalZoneService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regional-zones")
public class RegionalZoneController {
    private final RegionalZoneService regionalZoneService;
    public RegionalZoneController(RegionalZoneService regionalZoneService) {
        this.regionalZoneService = regionalZoneService;
    }
    @GetMapping
    public ResponseEntity<ResponseAPI> listAllProvince() {
        return ResponseEntity.status(200).body(new ResponseAPI("Zonas regionais do sistema", regionalZoneService.listAllResponse()));
    }
    @GetMapping ("/{id}")
    public ResponseEntity<ResponseAPI> findRegionalZoneById(@PathVariable(value = "id") Long id) throws NotFoundException {
        return ResponseEntity.status(200).body(new ResponseAPI("ID regionais do sistema", regionalZoneService.findByIdResponse(id)));
    }

}
