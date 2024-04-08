package com.personalprojects.MEDIC_ANALISYS.domains.demography.services;


import com.personalprojects.MEDIC_ANALISYS.domains.demography.dtos.response.ProvinceResponseDTO;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Province;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.RegionalZone;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories.ProvinceRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceService {

    private final ProvinceRepo provinceRepo;
    private final Logger logger = LoggerFactory.getLogger(ProvinceService.class);

    public ProvinceService(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    public List<Province> listAll() {
        return provinceRepo.findAll();
    }

    //Method to list province by regional zone
    public List<ProvinceResponseDTO> listProvinceByRegionalZone(RegionalZone regionalZone) throws NotFoundException{
        return provinceRepo.findByRegionalZone(regionalZone).stream().map(province -> new ProvinceResponseDTO(province.getId(), province.getDesignation(), province.getAcronym(), province.getCode(), province.getRegionalZone().getDesignation())).collect(Collectors.toList());
    }

    public Province findById(Long id) throws NotFoundException {
        return provinceRepo.findById(id).orElseThrow(() -> {
            logger.error("Erro, ProvinceService, findById, Provincia nao existe");
            return new NotFoundException(" Provincia nao existe");
        });
    }

    public List<ProvinceResponseDTO> listAllResponse() {
        return provinceRepo.findAll().stream().map(province -> new ProvinceResponseDTO(province.getId(), province.getDesignation(), province.getCode(), province.getAcronym(), province.getRegionalZone().getDesignation())).collect(Collectors.toList());
    }

    public ProvinceResponseDTO findByIdResponse(Long id) throws NotFoundException {
        Province province = provinceRepo.findById(id).orElseThrow(() -> {
            logger.error("Erro, ProvinceService, findById, Provincia nao existe");
            return new NotFoundException(" Provincia nao existe");
        });
        return new ProvinceResponseDTO(province.getId(), province.getDesignation(), province.getCode(), province.getAcronym(), province.getRegionalZone().getDesignation());
    }

    public Province findByCode(String code) throws NotFoundException {
        return provinceRepo.findByCode(code).orElseThrow(() -> {
            logger.error("Erro, ProvinceService, findById, Provincia nao existe");
            return new NotFoundException(" Provincia nao existe");
        });

    }
    public List<Province>provincesByIds(List<Long>ids){
        return provinceRepo.findByIdIn(ids);
    }
    public List<ProvinceResponseDTO> findByIdsRes(List<Long>ids){
        return provinceRepo.findByIdIn(ids).stream().map(province -> new ProvinceResponseDTO(province.getId(), province.getDesignation(), province.getCode(), province.getAcronym(), province.getRegionalZone().getDesignation())).collect(Collectors.toList());
    }

}

