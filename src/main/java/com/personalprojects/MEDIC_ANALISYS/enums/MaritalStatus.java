package com.personalprojects.MEDIC_ANALISYS.enums;

import lombok.Getter;

@Getter
public enum MaritalStatus {

    SINGLE("Solteiro"),
    MARRIED("Casado"),
    DIVORCED("Divorciado"),
    WIDOWED("Viúvo");;

    private final String value;

    MaritalStatus(String value) {
        this.value = value;
    }
}
