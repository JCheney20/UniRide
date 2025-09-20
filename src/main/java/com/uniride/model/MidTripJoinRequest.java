
package com.uniride.model;

public class MidTripJoinRequest {
    // This class appears to be empty in the diagram.
    // I will add some basic fields.
    private String passengerId;
    private String tripId;

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
