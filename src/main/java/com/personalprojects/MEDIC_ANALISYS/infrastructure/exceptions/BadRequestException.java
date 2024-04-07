package com.personalprojects.MEDIC_ANALISYS.infrastructure.exceptions;

public class BadRequestException extends Exception {
    public BadRequestException(String message){
        super(message);
    }
}
