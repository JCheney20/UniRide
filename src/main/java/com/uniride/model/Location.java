package com.uniride.model;

public class Location {
    private double latitude;
    private double longitude;
    private String address;
    private String landmark;

    // Constructor with latitude and longitude
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Constructor with all fields
    public Location(double latitude, double longitude, String address, String landmark) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.landmark = landmark;
    }

    // Default constructor (if needed, though not explicitly requested by error)
    public Location() {
    }

    public void getCoordinates() {}
    public void calculateDistance() {}
    public void validateAddress() {}

    // Getters and Setters

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}