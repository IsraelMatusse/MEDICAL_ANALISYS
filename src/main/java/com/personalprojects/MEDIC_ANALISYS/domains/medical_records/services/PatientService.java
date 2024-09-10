package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.DistrictService;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.services.ProvinceService;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.CreatePatientDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.PatientResDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.PatientResultDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.PatientRepo;
import com.personalprojects.MEDIC_ANALISYS.enums.BloodType;
import com.personalprojects.MEDIC_ANALISYS.enums.Genders;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.ConflictException;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;
    private final ProvinceService provinceService;
    private final DistrictService districtService;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(value = "medicalRecordsTransactionManager")
    public Patient create(Patient patient) {
        return patientRepo.save(patient);
    }

    @Transactional(value = "medicalRecordsTransactionManager")
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    @Transactional(value = "medicalRecordsTransactionManager")
    public Patient findById(UUID id) throws NotFoundException {
        return patientRepo.findById(id).orElseThrow(() -> new NotFoundException("Paciente não foi encontrado"));
    }

    @Transactional(value = "medicalRecordsTransactionManager")
    public Patient findByCode(String code) throws NotFoundException {
        return patientRepo.findByCode(code).orElseThrow(() -> new NotFoundException("Paciente não foi encontrado"));
    }

    @Transactional(value = "medicalRecordsTransactionManager")
    public boolean existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(String name, String surname, String msisdn, String fathersName, String mothersName) {
        return patientRepo.existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(name, surname, msisdn, fathersName, mothersName);
    }

    @Transactional(value = "medicalRecordsTransactionManager")
    public void createPatient(CreatePatientDto patientDto) throws ConflictException {
        try {
            if (existsByNameAndSurnameAndMsisdnAndFathersNameAndMothersName(patientDto.name(), patientDto.surname(), patientDto.msisdn(), patientDto.fathersName(), patientDto.mothersName())) {
                throw new ConflictException("Paciente já existe");
            }

            Patient patient = new Patient(patientDto);
            patientRepo.save(patient);
        } catch (ConflictException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(value = "medicalRecordsTransactionManager")
    public List<PatientResDto>findPatientsRes(){
        List<Patient>patients=patientRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return patients.stream().map(patient -> {
            try {
                return new PatientResDto(patient,provinceService.findById(patient.getProvinceId()).getDesignation(), districtService.findById(patient.getDistrictId()).getDesignation() );
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    public Object getPatientByParamns(String id, String code, String name, String surname, String msisdn, String documentNumber, String gender, String bloodType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);

        Root<Patient> root = cq.from(Patient.class);
        Predicate predicate = null;

        if (code != null) {
            predicate = cb.equal(root.get("code"), code);
        }
        if (id != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("id"), id);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("id"), id));
            }
        }
        if (name != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("name"), name);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("name"), name));
            }
        }
        if (surname != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("surname"), surname);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("surname"), surname));
            }
        }
        if (msisdn != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("msisdn"), msisdn);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("msisdn"), msisdn));
            }
        }
        if (documentNumber != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("documentNumber"), documentNumber);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("documentNumber"), documentNumber));
            }
        }
        if (gender != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("gender"), gender);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("gender"), gender));
            }
        }
        if (bloodType != null) {
            if (predicate == null) {
                predicate = cb.equal(root.get("bloodType"), bloodType);
            } else {
                predicate = cb.and(predicate, cb.equal(root.get("bloodType"), bloodType));
            }
        }

        if (predicate != null) {
            cq.where(predicate);
        }
        List<Patient> resultList = entityManager.createQuery(cq).getResultList();

        if (resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return resultList;
        }


    }


}
