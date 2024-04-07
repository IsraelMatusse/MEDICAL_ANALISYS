package com.personalprojects.MEDIC_ANALISYS.enums;

import lombok.Getter;

@Getter
public enum Genders {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTROS("Outros"),
    DESCONHECIDO("Desconhecido");

    private final String value;

    Genders(String value) {
        this.value = value;
    }
}
