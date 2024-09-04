package com.personalprojects.MEDIC_ANALISYS.enums;

import lombok.Getter;

@Getter
public enum LevelUrgency {

    BAIXO("BAIXO"),
    ALTO("ALTO"),
    MEDIO("MÉDIO");

    private final String value;

     LevelUrgency(String value) {
        this.value = value;
    }
}
