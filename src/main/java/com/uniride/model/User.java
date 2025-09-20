package com.uniride.model;

import java.time.LocalDateTime;

public abstract class User {
    private String userId;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String profilePicture;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private String emergencyContact;
    private double rating;

    // Constructor with userId and username
    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    // Default constructor
    public User() {
    }

    public abstract void register();
    public abstract void login();
    public abstract void updateProfile();
    public abstract void verifyAccount();
    public abstract void setPreferences();

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}