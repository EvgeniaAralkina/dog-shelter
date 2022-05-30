package com.example;

import java.util.List;

public class Form {
    Boolean genderM;
    Boolean genderF;
    Boolean young;
    Boolean old;
    Boolean middle;
    Boolean large;

    String username;
    Float age;
    String description;

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Form() {
    }

    public Boolean getGenderM() {
        return genderM;
    }

    public void setGenderM(Boolean genderM) {
        this.genderM = genderM;
    }

    public Boolean getGenderF() {
        return genderF;
    }

    public void setGenderF(Boolean genderF) {
        this.genderF = genderF;
    }

    public Boolean getYoung() {
        return young;
    }

    public void setYoung(Boolean young) {
        this.young = young;
    }

    public Boolean getOld() {
        return old;
    }

    public void setOld(Boolean old) {
        this.old = old;
    }

    public Boolean getMiddle() {
        return middle;
    }

    public void setMiddle(Boolean middle) {
        this.middle = middle;
    }

    public Boolean getLarge() {
        return large;
    }

    public void setLarge(Boolean large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "Form{" +
                "genderM=" + genderM +
                ", genderF=" + genderF +
                ", young=" + young +
                ", old=" + old +
                ", middle=" + middle +
                ", large=" + large +
                '}';
    }
}
