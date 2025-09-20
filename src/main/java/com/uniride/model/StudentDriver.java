package com.uniride.model;

import java.util.Date;

public class StudentDriver extends User {
    private String licenseNumber;
    private Date licenseExpiry;
    private Vehicle vehicle;
    private Location currentLocation; // Added
    private boolean available; // Added

    // Constructor
    public StudentDriver(String userId, String username, Location currentLocation) {
        super(userId, username);
        this.currentLocation = currentLocation;
        this.available = true; // Default to available
    }

    // Default constructor (if needed, though not explicitly requested by error)
    public StudentDriver() {
        super();
    }

    public void submitLicense() {}
    public void postRide() {}
    public void acceptPassenger() {}
    public void startTrip() {}
    public void completeTrip() {}
    public void reviewPassengerRatings() {}

    // Getters and Setters

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseExpiry() {
        return licenseExpiry;
    }

    public void setLicenseExpiry(Date licenseExpiry) {
        this.licenseExpiry = licenseExpiry;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Getters and Setters for new fields
    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Overridden methods from User (assuming username is used for getName())
    public String getName() {
        return getUsername(); // Assuming getName() should return the username
    }

    @Override
    public void register() {

    }

    @Override
    public void login() {

    }

    @Override
    public void updateProfile() {

    }

    @Override
    public void verifyAccount() {

    }

    @Override
    public void setPreferences() {

    }
}