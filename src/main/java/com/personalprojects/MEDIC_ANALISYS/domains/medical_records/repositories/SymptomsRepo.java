package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SymptomsRepo extends JpaRepository<Symptoms, String> {

    List<Symptoms>findByScreening(Screening screening);
}
