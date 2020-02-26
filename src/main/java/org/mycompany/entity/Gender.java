package org.mycompany.entity;

public enum Gender {
    FEMALE("F"), MALE("M"), OTHER("O");

    private String code;

    private Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
