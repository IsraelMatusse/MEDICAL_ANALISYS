package com.personalprojects.MEDIC_ANALISYS.domains.demography.services;


import com.personalprojects.MEDIC_ANALISYS.domains.demography.dtos.response.DistrictResponseDTO;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.District;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Province;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories.DistrictRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictService {
    private final DistrictRepo districtRepo;

    private final Logger logger = LoggerFactory.getLogger(DistrictService.class);

    public DistrictService(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }

    public List<DistrictResponseDTO> listAllResponse() {
        return districtRepo.findAll().stream().map(district -> new DistrictResponseDTO(district.getId(), district.getDesignation(), district.getCode(), district.getProvince().getDesignation())).collect(Collectors.toList());
    }
    public District findById(Long id) throws NotFoundException {
        return districtRepo.findById(id).orElseThrow(() -> {
            logger.error("Error, DistricService:findById, O distrito nao existe");
            return new NotFoundException("O distrito nao existe");
        });

    }

    public DistrictResponseDTO findByIdResponse(Long id) throws NotFoundException {
        District district = districtRepo.findById(id).orElseThrow(() -> {
            logger.error("Error, DistricService:findById, O distrito nao existe");
            return new NotFoundException("O distrito nao existe");
        });
        return new DistrictResponseDTO(district.getId(), district.getDesignation(), district.getCode(), district.getProvince().getDesignation());
    }

    public List<DistrictResponseDTO> listByProvince(Province province) {
        return districtRepo.findByProvince(province).stream().map(district -> new DistrictResponseDTO(district.getId(), district.getDesignation(), district.getCode(), district.getProvince().getDesignation())).collect(Collectors.toList());
    }

    public District findByCode(String code) throws NotFoundException {
        return districtRepo.findByCode(code).orElseThrow(() -> {
            logger.error("Erro, DisctrictService: findByIdAndProvinceCode, O distito buscado nao existe ");
            return new NotFoundException("O distito buscado nao existe ou nao pertence a provincia inserida");
        });
    }

    public District findByProvinceAndDistrictCode(Province province, String code) throws NotFoundException {
        return districtRepo.findByProvinceAndCode(province, code).orElseThrow(() -> {
            logger.error("Erro, DisctrictService: findByProvinceAndDistrictCode, O districto buscado nao existe ou nao pertence a provincia inserida");
            return new NotFoundException("O districto buscado nao existe ou nao pertence a provincia inserida");
        });
    }

    public DistrictResponseDTO findByProvinceAndDistrictCodeResponse(Province province, String code) throws NotFoundException {
        District district= districtRepo.findByProvinceAndCode(province, code).orElseThrow(() -> {
            logger.error("Erro, DisctrictService: findByProvinceAndDistrictCode, O districto buscado nao existe ou nao pertence a provincia inserida");
            return new NotFoundException("O districto buscado nao existe ou nao pertence a provincia inserida");
        });
        return new DistrictResponseDTO(district.getId(), district.getDesignation(), district.getCode(), district.getProvince().getDesignation());
    }

    public List<District>districtsByIds(List<Long>ids){
        return districtRepo.findByIdIn(ids);
    }
    public List<DistrictResponseDTO>districtsByIdsRes(List<Long>ids){
        return districtRepo.findByIdIn(ids).stream().map(district -> new DistrictResponseDTO(district.getId(), district.getDesignation(), district.getCode(), district.getProvince().getDesignation())).collect(Collectors.toList());
    }
}



