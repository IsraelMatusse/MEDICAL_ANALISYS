package com.personalprojects.MEDIC_ANALISYS.domains.demography.controllers;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Province;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.DistrictService;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.ProvinceService;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.ResponseAPI;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {
    private final DistrictService districtService;
    private final ProvinceService provinceService;

    public DistrictController(DistrictService districtService, ProvinceService provinceService) {
        this.districtService = districtService;
        this.provinceService = provinceService;
    }
    @GetMapping
    public ResponseEntity<ResponseAPI> listAllDistrict() {
        return ResponseEntity.status(200).body(new ResponseAPI("Distritos do sistema", districtService.listAllResponse()));
    }
    @GetMapping ("/{id}")
    public ResponseEntity<ResponseAPI> findDistrictById(@PathVariable(value = "id") Long id) throws NotFoundException {
        return ResponseEntity.status(200).body(new ResponseAPI("ID dos Distritos do sistema", districtService.findById(id)));
    }
    @GetMapping ("/ids/{ids}")
    public ResponseEntity<ResponseAPI> findDistrictById(@PathVariable(value = "ids") List<Long> ids) throws NotFoundException {
        return ResponseEntity.status(200).body(new ResponseAPI("ID dos Distritos do sistema", districtService.districtsByIdsRes(ids)));
    }
    @GetMapping("/province/{code}")
    public ResponseEntity<ResponseAPI>listDistrictByProvince(@PathVariable(value = "code") String code) throws NotFoundException {
        Province province=provinceService.findByCode(code);
        return ResponseEntity.status(200).body(new ResponseAPI("Districtos de " + province.getDesignation(), districtService.listByProvince(province)));
    }
    @GetMapping("/province/{province-code}/district/{district-code}")
    public ResponseEntity<ResponseAPI>districtFromProvince(@PathVariable(value = "province-code") String provinceCode, @PathVariable(value = "district-code") String districtCode) throws NotFoundException {
        Province province=provinceService.findByCode(provinceCode);
        return ResponseEntity.status(200).body(new ResponseAPI("Districtos de " + province.getDesignation(), districtService.findByProvinceAndDistrictCode(province, districtCode )));
    }
}



