package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Ocupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupationRepo extends JpaRepository<Ocupation, String> {

    Ocupation findByDescription(String description);
}
