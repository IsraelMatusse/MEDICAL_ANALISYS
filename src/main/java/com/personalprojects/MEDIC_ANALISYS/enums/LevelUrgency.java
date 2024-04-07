package com.personalprojects.MEDIC_ANALISYS.enums;

import lombok.Getter;

@Getter
public enum LevelUrgency {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String value;

     LevelUrgency(String value) {
        this.value = value;
    }
}
