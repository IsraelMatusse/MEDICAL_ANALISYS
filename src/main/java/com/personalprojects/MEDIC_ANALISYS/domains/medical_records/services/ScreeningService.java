package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.services;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.ScreeningCreateDto;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Screening;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Symptoms;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.VitalSigns;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.ScreeningRepo;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.SymptomsRepo;
import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.VitalSighnsRepo;
import com.personalprojects.MEDIC_ANALISYS.enums.LevelUrgency;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepo screeningRepo;
    private final VitalSighnsRepo vitalSighnsRepo;
    private final PatientService patientService;
    private final SymptomsRepo symptomsRepo;

    public Screening create(Screening screening){
        return screeningRepo.save(screening);
    }
    public Screening findById(String id) throws NotFoundException {
        return screeningRepo.findById(id).orElseThrow(()->new NotFoundException("Triagem não encontrado"));
    }

    @Transactional
    public void CreateScreening(ScreeningCreateDto screeningDto) throws NotFoundException {

        Patient patient= patientService.findByCode(screeningDto.patientCode());

        VitalSigns vitalSigns= new VitalSigns(screeningDto);
        vitalSighnsRepo.save(vitalSigns);

        LevelUrgency levelUrgency= LevelUrgency.valueOf(screeningDto.urgency().getValue());

        Screening screening= new Screening(screeningDto,patient, vitalSigns,levelUrgency.getValue());
        create(screening);

        List<Symptoms>symptoms= new ArrayList<>();
        Symptoms symptom;
        for (int i=0; i<screeningDto.symptoms().size(); i++){
            symptom= new Symptoms(screeningDto.symptoms().get(i).description(), screening);
            symptoms.add(symptom);
        }
        symptomsRepo.saveAll(symptoms);
    }
}
