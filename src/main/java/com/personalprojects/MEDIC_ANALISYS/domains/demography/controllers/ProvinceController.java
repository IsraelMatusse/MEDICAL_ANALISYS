package com.personalprojects.MEDIC_ANALISYS.domains.demography.controllers;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.RegionalZone;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.ProvinceService;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.RegionalZoneService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
@RequiredArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;
    private final RegionalZoneService regionalZoneService;


    @GetMapping
    public ResponseEntity<ResponseAPI> listAllProvince() {
        return ResponseEntity.status(200).body(new ResponseAPI("Provincias do sistema", provinceService.listAllResponse()));
    }
    @GetMapping ("/{id}")
    public ResponseEntity<ResponseAPI> findProvinceById(@PathVariable(value = "id") Long id) throws NotFoundException {
        return ResponseEntity.status(200).body(new ResponseAPI("ID das provincias do sistema", provinceService.findById(id)));
    }
    @GetMapping ("/ids/{ids}")
    public ResponseEntity<ResponseAPI> findProvinceById(@PathVariable(value = "ids") List<Long> ids) throws NotFoundException {
        return ResponseEntity.status(200).body(new ResponseAPI("ID das provincias do sistema", provinceService.findByIdsRes(ids)));
    }

    @GetMapping("/regional-zone/{regional-zone-id}")
    public ResponseEntity<ResponseAPI> listProvinceByRegionalZone (@PathVariable(value = "regional-zone-id") Long id) throws NotFoundException {
        RegionalZone regionalZone = regionalZoneService.findById(id);
        return ResponseEntity.status(200).body(new ResponseAPI("Provincias da Zona Regional", provinceService.listProvinceByRegionalZone(regionalZone)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ResponseAPI>findProvinceByCode(@PathVariable(value = "code") String code) throws NotFoundException {
        return ResponseEntity.status(200).body(new ResponseAPI("Provincia com o codigo", provinceService.findByCode(code)));
    }
}
