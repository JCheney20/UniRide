
package com.uniride.model;

import com.uniride.enums.RideStatus;

import java.time.LocalDateTime;

public class Ride {
    private String rideId;
    private String driverId;
    private Location startLocation;
    private Location endLocation;
    private LocalDateTime departureTime;
    private int availableSeats;
    private double pricePerSeat;
    private RideStatus status;
    private boolean isMultiStop;
    private int estimatedDuration;
    private LocalDateTime createdAt;

    public void createRide() {}
    public void modifyRide() {}
    public void cancelRide() {}
    public void optimizeMultiStopPickups() {}
    public void estimateTravelTime() {}

    // Getters and Setters

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

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public boolean isMultiStop() {
        return isMultiStop;
    }

    public void setMultiStop(boolean multiStop) {
        isMultiStop = multiStop;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
