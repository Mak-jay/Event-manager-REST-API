package com.jay.EventManager.DTOs;

import java.time.LocalDate;

public class UserDTO {

    private String email;
    private String userName;
    private String mobileNumber;
    private LocalDate dateOfBirth;

    public UserDTO() {
    }

    public UserDTO(String email, String userName, String mobileNumber, LocalDate dateOfBirth) {
        this.email = email;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
