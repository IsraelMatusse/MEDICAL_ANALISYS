package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PatientResultDto{

     private   Patient patient;
     private  List<Patient> patients;

    public void setPatient(Patient patient) {
        this.patient = patient;
        this.patients = null; // Certifique-se de limpar a lista quando definir um objeto único
    }

    public void setPatientList(List<Patient> patients) {
        this.patients = patients;
        this.patient = null; // Certifique-se de limpar o objeto quando definir uma lista
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Patient> getPatientList() {
        return patients;
    }

    public boolean isList() {
        return patients != null;
    }
    }
