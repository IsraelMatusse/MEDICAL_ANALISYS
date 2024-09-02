package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.dtos.CreatePatientDto;
import com.personalprojects.MEDIC_ANALISYS.enums.BloodType;
import com.personalprojects.MEDIC_ANALISYS.enums.Genders;
import com.personalprojects.MEDIC_ANALISYS.infrastructure.utils.GenerateCodes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String surname;
    @Column(name = "fathers_name")
    private String fathersName;
    @Column(name = "mothers_name")
    private String mothersName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "neighboor_hood")
    private String neighboorHood;
    @Column(name = "document_number")
    private String documentNumber;
    private String msisdn;
    @Column(unique = true)
    private String email;
    @Column( name = "road")
    private String road;
    @Column( name = "house_nr")
    private String houseNr;
    private float height;
    private float weight;
    private String code;
    private String gender;
    @Column(name = "blood_type")
    private String bloodType;
    @Column(name = "province_id")
    private Long provinceId;
    @Column(name = "district_id")
    private Long districtId;

    public Patient(CreatePatientDto patent) {
        this.code= GenerateCodes.generateBarcode();
        this.birthDate=patent.birthDate();
        this.fathersName= patent.fathersName();
        this.email= patent.email();
        this.height=patent.height();
        this.weight=patent.weight();
        this.road =patent.roadNumber();
        this.houseNr=patent.houseNumber();
        this.name=patent.name();
        this.surname=patent.surname();
        this.mothersName= patent.mothersName();
        this.msisdn=patent.msisdn();
        this.documentNumber=patent.documentNumber();
        this.neighboorHood=patent.neighboorHood();
        this.bloodType=patent.bloodType();
        this.gender=patent.gender();
        this.districtId=patent.districtId();
        this.provinceId=patent.provinceId();
    }


    public Patient(Patient patient) {
        this.code= patient.code;
        this.birthDate=patient.birthDate;
        this.fathersName= patient.fathersName;
        this.email= patient.email;
        this.height=patient.height;
        this.weight=patient.weight;
        this.road =patient.road;
        this.houseNr=patient.houseNr;
        this.name=patient.name;
        this.surname=patient.surname;
        this.mothersName= patient.mothersName;
        this.msisdn=patient.msisdn;
        this.documentNumber=patient.documentNumber;
        this.neighboorHood=patient.neighboorHood;
        this.bloodType=patient.bloodType;
        this.gender=patient.gender;
    }

}
