package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String surname;
    @Column(name = "created_at")
    private Date createdAt;
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
    private String code;
    private String gender;
    @Column(name = "province_id")
    private Long provinceId;
    @Column(name = "district_id")
    private Long districtId;
}
