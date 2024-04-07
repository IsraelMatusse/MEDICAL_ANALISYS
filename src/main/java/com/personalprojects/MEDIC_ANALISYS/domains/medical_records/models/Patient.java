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
import java.util.UUID;

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
    @Column(unique = true, nullable = true)
    private String email;
    @Column(nullable = true, name = "road_nr")
    private String roadNr;
    @Column(nullable = true, name = "house_nr")
    private String houseNr;
    private float height;
    private float weight;
    private String code;
    private String gender;
    @Column(name = "blood_type")

    private String bloodType;

    public Patient(CreatePatientDto patent, String gender, String bloodType) {
        this.code= GenerateCodes.generateBarcode();
        this.birthDate=patent.birthDate();
        this.fathersName= patent.fathersName();
        this.email= patent.email();
        this.height=patent.height();
        this.weight=patent.weight();
        this.roadNr=patent.roadNumber();
        this.houseNr=patent.houseNumber();
        this.name=patent.name();
        this.surname=patent.surname();
        this.mothersName= patent.mothersName();
        this.msisdn=patent.msisdn();
        this.documentNumber=patent.documentNumber();
        this.neighboorHood=patent.neighboorHood();
        this.bloodType=bloodType;
        this.gender=gender;

    }



}
