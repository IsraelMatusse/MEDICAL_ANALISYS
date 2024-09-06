package com.personalprojects.MEDIC_ANALISYS.domains.demography.services;


import com.personalprojects.MEDIC_ANALISYS.domains.demography.dtos.response.RegionalZoneResponseDTO;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.RegionalZone;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories.RegionalZoneRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionalZoneService {

    private final RegionalZoneRepo regionalZoneRepo;
    private final Logger logger = LoggerFactory.getLogger(RegionalZoneService.class);

    public RegionalZoneService(RegionalZoneRepo regionalZoneRepo) {
        this.regionalZoneRepo = regionalZoneRepo;
    }

    public List<RegionalZoneResponseDTO> listAllResponse() {
        return regionalZoneRepo.findAll().stream().map(regionalZone -> new RegionalZoneResponseDTO(regionalZone.getId(), regionalZone.getDesignation())).collect(Collectors.toList());
    }

    public RegionalZone findById(Long id) throws NotFoundException {
        return regionalZoneRepo.findById(id).orElseThrow(() -> {
            logger.error("Erro,RegionalZOneService: findByID, Zona regional nao foi encontrada");
            return new NotFoundException(" Zona regional nao foi encontrada");
        });
    }


    public RegionalZoneResponseDTO findByIdResponse(Long id) throws NotFoundException {
        RegionalZone regionalZone = regionalZoneRepo.findById(id).orElseThrow(() -> {
            logger.error("Erro, RegionalZoneService, findById, Provincia nao existe");
            return new NotFoundException(" Provincia nao existe");
        });
        return new RegionalZoneResponseDTO(regionalZone.getId(), regionalZone.getDesignation());


    }

}