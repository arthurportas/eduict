package com.eduict.enums;

/**
 * Created by Arthur on 12/10/14.
 */
public enum Role {

    TEACHER("Professor"), DIRECTOR("Diretor"), Other("Outra");

    private String value;

    private Role(String value) {
        value = value;
    }

    public String getValue() {
        return value;
    }
}
