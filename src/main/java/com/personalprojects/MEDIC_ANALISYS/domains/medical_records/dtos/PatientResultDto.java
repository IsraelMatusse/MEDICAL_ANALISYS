package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientResultDto{

     private   Patient patient;
     private  List<Patient> patients;

     public PatientResultDto(Patient patient) {
         this.patient = patient;
     }
     public PatientResultDto ( List<Patient> patients){
         this.patients = patients;}
}
