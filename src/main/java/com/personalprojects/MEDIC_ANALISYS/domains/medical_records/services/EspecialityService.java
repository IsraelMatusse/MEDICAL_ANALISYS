package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Especiality;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.EspecialityRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialityService {

    private final EspecialityRepo especialityRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(value = "medicalRecordsTransactionManager")
    public Especiality create(Especiality especiality){
        return especialityRepo.save(especiality);
    }
    @Transactional(value = "medicalRecordsTransactionManager")
    public Especiality update(Especiality especiality){
        return especialityRepo.save(especiality);
    }
    @Transactional(value = "medicalRecordsTransactionManager")
    public Especiality findById(Long id) throws NotFoundException {
        return especialityRepo.findById(id).orElseThrow(()->new NotFoundException("Especialidade não encontrada"));
    }
    @Transactional(value = "medicalRecordsTransactionManager")
    public List<Especiality> findAll(){
        return especialityRepo.findAll(Sort.by("designation").ascending());
    }

}
