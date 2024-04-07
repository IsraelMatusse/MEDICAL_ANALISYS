package com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.models.Strains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StrainsRepo extends JpaRepository<Strains, String> {
}
