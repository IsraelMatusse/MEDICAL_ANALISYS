package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.VitalSignsRegisterDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.VitalSigns;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.VitalSignsRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VitalSignsService {

    private final VitalSignsRepo vitalSignsRepo;

    public VitalSigns create(VitalSigns vitalSigns){
        return vitalSignsRepo.save(vitalSigns);
    }
    public VitalSigns findById(String id) throws NotFoundException {
        return vitalSignsRepo.findById(id).orElseThrow(()-> new NotFoundException("Sinal vital não forim"));
    }

    public VitalSigns crateVitalSigns(VitalSignsRegisterDto vitalSignsData){
        VitalSigns vitalSigns= new VitalSigns(vitalSignsData);
        vitalSignsRepo.save(vitalSigns);
        return  vitalSigns;
    }

    public List<VitalSigns>findAll(){
        return vitalSignsRepo.findAll(Sort.by("created_at").descending());
    }
}
