
package com.uniride.model;

public class StudentPassenger extends User {
    private String studentId;
    private String preferredDriver;
    private String paymentMethod;

    public void searchRides() {}
    public void requestRide() {}
    public void payForRide() {}
    public void rateDriver() {}
    public void useEmergency() {}
    public void cancelRideBooking() {}

    // Getters and Setters

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPreferredDriver() {
        return preferredDriver;
    }

    public void setPreferredDriver(String preferredDriver) {
        this.preferredDriver = preferredDriver;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
