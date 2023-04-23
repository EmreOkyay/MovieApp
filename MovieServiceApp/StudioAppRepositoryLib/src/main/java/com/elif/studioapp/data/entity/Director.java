package com.elif.studioapp.data.entity;

import java.time.LocalDate;
import java.util.Optional;

public class Director {
    public long directorId;
    public String firstName;
    public Optional<String> middleName;
    public String familyName;
    public LocalDate birthDate;

    public Director()
    {}

    public Director(long directorId, String firstName, Optional<String> middleName, String familyName, LocalDate birthDate)
    {
        this.directorId = directorId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.birthDate = birthDate;
    }

    public long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(long directorId) {
        this.directorId = directorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName.orElse(null);
    }

    public Optional<String> getMiddleNameOpt() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = Optional.ofNullable(middleName);
    }

    public void setMiddleNameOpt(Optional<String> middleName)
    {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
