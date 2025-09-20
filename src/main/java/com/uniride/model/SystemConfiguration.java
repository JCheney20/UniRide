
package com.uniride.model;

import java.util.List;

public class SystemConfiguration {
    private String configId;
    private double maxRideDistance;
    private int maxPassengers;
    private List<String> emergencyContacts;
    private boolean maintenanceMode;

    public void updateConfiguration() {}
    public void getConfigValue() {}
    public void enableMaintenance() {}

    // Getters and Setters

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public double getMaxRideDistance() {
        return maxRideDistance;
    }

    public void setMaxRideDistance(double maxRideDistance) {
        this.maxRideDistance = maxRideDistance;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public List<String> getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(List<String> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public boolean isMaintenanceMode() {
        return maintenanceMode;
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }
}
