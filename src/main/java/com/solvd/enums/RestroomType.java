package com.solvd.enums;

public enum RestroomType {
    MALE("Male"),
    FEMALE("Female");

    private final String sex;

    RestroomType(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

}
