package com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryRepo extends JpaRepository<Country, Long> {
}
