package com.personalprojects.MEDIC_ANALISYS.domains.demography.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.personalprojects.MEDIC_ANALISYS.domains.SystemActions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="province")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Province extends SystemActions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String code;
    private String acronym;
    @ManyToOne
    private RegionalZone regionalZone;
}
