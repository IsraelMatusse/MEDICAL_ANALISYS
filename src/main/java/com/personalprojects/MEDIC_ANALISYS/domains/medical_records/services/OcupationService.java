package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Ocupation;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.OcupationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OcupationService {

    private final OcupationRepo ocupationRepo;

    public Ocupation create(Ocupation ocupation){
        return ocupationRepo.save(ocupation);
    }
    public List<Ocupation> findAll(){return ocupationRepo.findAll();}
    public Ocupation findById(String id) {
        return ocupationRepo.findById(id).orElseThrow(() -> new RuntimeException("Ocupação não foi encontrado"));
    }

    public Ocupation findOrCreate(String description) {
        Ocupation ocupation=ocupationRepo.findByDescription(description);
            if(ocupation!=null){
                return ocupation;
            }
        Ocupation newOcupation;
            try{
                newOcupation= new Ocupation(null,description);
                ocupationRepo.save(newOcupation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return newOcupation;
        }

}
