package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepo extends JpaRepository<Patient, UUID> {

    Optional<Patient>findByCode(String code);

    boolean existsByDocumentNumber(String documentNumber);
    boolean existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(String name, String surname, String msisdn, String fathersName, String mothersName);

}
