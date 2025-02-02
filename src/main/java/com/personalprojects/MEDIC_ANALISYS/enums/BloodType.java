package com.personalprojects.MEDIC_ANALISYS.enums;

import lombok.Getter;

@Getter
public enum BloodType {

    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-"),
    DESCONHECIDO("Desconhecido");

    private final String value;

    BloodType(String value) {
        this.value = value;
    }

    public static BloodType fromString(String value) {
        for (BloodType type : BloodType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid blood type: " + value);
    }

}
