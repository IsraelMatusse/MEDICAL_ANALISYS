package com.personalprojects.MEDIC_ANALISYS.domains.demography.models;

import com.personalprojects.MEDIC_ANALISYS.domains.SystemActions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="district")
@AllArgsConstructor

public class District extends SystemActions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String code;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

}
