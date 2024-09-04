package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.SymptomsRegisterDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.SymptomsResDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Symptoms;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.SymptomsRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomsService {

    private final SymptomsRepo symptomsRepo;

    public Symptoms create(Symptoms symptoms){
        return symptomsRepo.save(symptoms);
    }

    public List<Symptoms>findByScreening(Screening screening){
        return symptomsRepo.findByScreening(screening);
    }

    public List<SymptomsResDto>findByScreeningRes(Screening screening){
        return symptomsRepo.findByScreening(screening).stream().map(symptoms -> new SymptomsResDto(symptoms)).toList();
    }
    public Symptoms findById(String  id) throws NotFoundException {
        return symptomsRepo.findById(id).orElseThrow(()->new NotFoundException("Sintoma não encontrado"));
    }

    public List<Symptoms>createBatch(List<Symptoms>symptoms){
        return symptomsRepo.saveAll(symptoms);
    }

    public Symptoms createSymptoms(SymptomsRegisterDto symptomsData, Screening screening){
        Symptoms symptoms= new Symptoms(symptomsData, screening);
        symptomsRepo.save(symptoms);
        return  symptoms;
    }

    public List<Symptoms>createSymptomsBatch(List<SymptomsRegisterDto> symptomsRegisterDtos, Screening screening){
        List<Symptoms> symptoms=symptomsRegisterDtos
                .stream()
                .map(symptomsRegisterDto -> new Symptoms(symptomsRegisterDto, screening))
                .toList();
        return this.createBatch(symptoms);
    }


}
