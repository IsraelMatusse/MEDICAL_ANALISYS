package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepo extends JpaRepository<Screening, String> {
}