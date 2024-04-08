package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SymptomsRepo extends JpaRepository<Symptoms, String> {
}
