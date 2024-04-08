package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.ScreeningRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepo screeningRepo;

    public Screening create(Screening screening){
        return screeningRepo.save(screening);
    }
    public Screening findById(String id) throws NotFoundException {
        return screeningRepo.findById(id).orElseThrow(()->new NotFoundException("Triagem não encontrado"));
    }
}
