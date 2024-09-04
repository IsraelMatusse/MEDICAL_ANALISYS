package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.PatientResponseDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningRegisterDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningResDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.VitalSignsResDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Symptoms;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.VitalSigns;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.ScreeningRepo;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepo screeningRepo;
    private final VitalSignsService vitalSignsService;
    private final PatientService patientService;
    private final SymptomsService symptomsService;
    private final Logger logger= org.slf4j.LoggerFactory.getLogger(ScreeningService.class);

    public Screening create(Screening screening){
        return screeningRepo.save(screening);
    }

    public Screening findById(String id) throws NotFoundException {
        return screeningRepo.findById(id).orElseThrow(()->new NotFoundException("Screening not found"));
    }

    public List<Screening>findAll(){
        return screeningRepo.findAll(Sort.by("screeningDate").descending());
    }

    public List<ScreeningResDto>findAllScreenings(){
        List<Screening>screenings=this.findAll();
        return screenings.stream().map(screening -> new ScreeningResDto(screening, new PatientResponseDto(screening.getPatient()), new VitalSignsResDto(screening.getVitalSigns()), symptomsService.findByScreeningRes(screening))).toList();
    }

    public ScreeningResDto findByIdRes(String id) throws NotFoundException {
        Screening screening=this.findById(id);
        return new ScreeningResDto(screening, new PatientResponseDto(screening.getPatient()), new VitalSignsResDto(screening.getVitalSigns()), symptomsService.findByScreeningRes(screening));
    }

    @Transactional(rollbackFor = Exception.class, value = "medicalRecordsTransactionManager")
    public Screening createScreening(ScreeningRegisterDto screeningData) throws NotFoundException {
        Screening screening = null;
        try {
            VitalSigns vitalSigns = vitalSignsService.crateVitalSigns(screeningData.vitalSigns());
            Patient patient = patientService.findByCode(screeningData.patientCode());

            screening = new Screening(screeningData, patient, vitalSigns);
            screeningRepo.save(screening);

            symptomsService.createSymptomsBatch(screeningData.symptoms(), screening);

        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            logger.error("Error creating screening", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return screening;
    }

}
