package com.personalprojects.MEDIC_ANALISYS.enums;

import lombok.Getter;

@Getter
public enum PatogenicalType {

    BACTERIAL("Bacterial"),
    VIRAL("Viral"),
    FUNGI("Fungi"),
    HELMINTH("Helminth"),
    OTHER("Other"),
    UNKNOWN("Unknown");
    private final String value;

    PatogenicalType(String value) {
        this.value = value;
    }
}
