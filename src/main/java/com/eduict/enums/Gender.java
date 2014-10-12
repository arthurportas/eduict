package com.eduict.enums;

/**
 * Created by Arthur on 12/10/14.
 */
public enum Gender {

    MALE("Masculino"), FEMALE("Feminino");

    private String value;

    private Gender(String value) {
        value = value;
    }

    public String getValue() {
        return value;
    }
}
