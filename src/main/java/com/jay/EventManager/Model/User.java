package com.jay.EventManager.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false,unique = true)
    private String userEmail;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "First Name must not contain numbers or special characters")
    @Size(min = 2, max = 20, message = "First Name must be between 2 and 30 characters long")
    private String userName;

    @Pattern(regexp = "^\\d{10}$", message = "Mobile Number must contain only Numbers")
    @Size(min = 10, max = 10, message = "Mobile Number must be exactly 10 digits long")
    private String mobileNumber;

    private String userPassword;

    private LocalDate dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Event> events = new ArrayList<>();


    public User() {
    }

    public User(String userEmail, String userName, String mobileNumber, String userPassword, LocalDate dateOfBirth, List<Event> events) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
        this.dateOfBirth = dateOfBirth;
        this.events = events;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
