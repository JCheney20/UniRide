
package com.uniride.model;

import java.util.List;

public class TripHistory {
    private String historyId;
    private String userId;
    private List<Trip> completedTrips;
    private double totalDistance;
    private double totalSpent;
    private int totalTrips;

    public void addTripToHistory() {}
    public void getHistoryByUser() {}
    public void generateStatistics() {}
    public void viewTripHistory() {}

    // Getters and Setters

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Trip> getCompletedTrips() {
        return completedTrips;
    }

    public void setCompletedTrips(List<Trip> completedTrips) {
        this.completedTrips = completedTrips;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public int getTotalTrips() {
        return totalTrips;
    }

    public void setTotalTrips(int totalTrips) {
        this.totalTrips = totalTrips;
    }
}
