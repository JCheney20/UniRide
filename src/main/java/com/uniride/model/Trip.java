
package com.uniride.model;

import com.uniride.enums.TripStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Trip {
    private String tripId;
    private String rideId;
    private String driverId;
    private List<String> passengers;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Location> actualRoute;
    private TripStatus status;
    private boolean isEmergencyActivated;

    public void startTrip() {}
    public void updateLocation() {}
    public void completeTrip() {}
    public void markAsFinished() {}
    public void activateEmergency() {}
    public void sendLiveLocation() {}
    public void calculateMidTripDetourImpact() {}
    public void recalculateFareForMidTripJoin() {}

    // Getters and Setters

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<String> passengers) {
        this.passengers = passengers;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Location> getActualRoute() {
        return actualRoute;
    }

    public void setActualRoute(List<Location> actualRoute) {
        this.actualRoute = actualRoute;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public boolean isEmergencyActivated() {
        return isEmergencyActivated;
    }

    public void setEmergencyActivated(boolean emergencyActivated) {
        isEmergencyActivated = emergencyActivated;
    }
}
