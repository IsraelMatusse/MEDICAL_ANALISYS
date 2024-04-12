package com.personalprojects.MEDIC_ANALISYS.domains.demography.services;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Country;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepo countryRepo;

    public Country create(Country country){
        return countryRepo.save(country);
    }
    public List<Country> findAll(){return countryRepo.findAll();}
    public Country findById(Long id){return countryRepo.findById(id).orElseThrow(()-> new RuntimeException("Pais não foi encontrado"));}
}
