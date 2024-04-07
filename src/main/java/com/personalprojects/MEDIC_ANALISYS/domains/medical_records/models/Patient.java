package com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models;

import com.personalprojects.MEDIC_ANALISYS.enums.BloodType;
import com.personalprojects.MEDIC_ANALISYS.enums.Genders;
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
    private String fathersName;
    private String mothersName;
    private Date birthDate;
    private String neighboorHood;
    private String msisdn;
    @Column(unique = true, nullable = true)
    private String email;
    @Column(nullable = true)
    private String roadNr;
    @Column(nullable = true)
    private String houseNr;
    private float height;
    private float weight;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    @Enumerated(EnumType.STRING)
    private Genders gender;


}
