package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.CreatePatientDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.PatientRepo;
import com.personalprojects.MEDIC_ANALISYS.enums.BloodType;
import com.personalprojects.MEDIC_ANALISYS.enums.Genders;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;

    @Transactional(value = "medicalRecordsEntityManager")
    public Patient create(Patient patient){
        return patientRepo.save(patient);
    }

    @Transactional(value = "medicalRecordsEntityManager")
    public List<Patient>findAll(){
        return patientRepo.findAll();
    }
    @Transactional(value = "medicalRecordsEntityManager")
    public Patient findById(UUID id) throws NotFoundException {
        return patientRepo.findById(id).orElseThrow(()->new NotFoundException("Paciente não foi encontrado"));
    }

    @Transactional(value = "medicalRecordsEntityManager")
    public Patient findByCode(String code) throws NotFoundException {
        return patientRepo.findByCode(code).orElseThrow(()->new NotFoundException("Paciente não foi encontrado"));
    }

   //  @Transactional(value = "medicalRecordsEntityManager")
    public  boolean existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(String name, String surname, String msisdn, String fathersName, String mothersName){
        return patientRepo.existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(name, surname, msisdn, fathersName, mothersName);
    }
  //  @Transactional(value = "medicalRecordsEntityManager")
    public void createPatient(CreatePatientDto patientDto){

        if(existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(patientDto.name(), patientDto.surname(), patientDto.msisdn(), patientDto.fathersName(), patientDto.mothersName())){
            throw new RuntimeException("Paciente já existe");
        }
       /* Genders gender= Genders.valueOf(patientDto.gender().toUpperCase());
        System.out.println(gender);
        BloodType bloodType = BloodType.valueOf(patientDto.bloodType().toUpperCase());
           System.out.println(bloodType);

        */
        Patient patient= new Patient(patientDto);
        patientRepo.save(patient);
    }

}
