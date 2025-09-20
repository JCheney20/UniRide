package com.uniride.service;

import com.uniride.model.StudentDriver;
import com.uniride.model.Location;
import com.uniride.model.RideRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    private final List<StudentDriver> drivers = new ArrayList<>();
    private final NotificationService notificationService;

    @Autowired
    public DriverService(NotificationService notificationService) {
        this.notificationService = notificationService;
        // Add some dummy drivers
        drivers.add(new StudentDriver("1", "Driver 1", new Location(34.0522, -118.2437)));
        drivers.add(new StudentDriver("2", "Driver 2", new Location(34.0522, -118.2537)));
        drivers.add(new StudentDriver("3", "Driver 3", new Location(34.0622, -118.2437)));
    }

    public void requestRide(RideRequest rideRequest) {
        StudentDriver nearestDriver = findNearestDriver(rideRequest.getPickupLocation());
        if (nearestDriver != null) {
            notificationService.sendRideRequestToDriver(nearestDriver, rideRequest);
        }
    }

    private StudentDriver findNearestDriver(Location pickupLocation) {
        StudentDriver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (StudentDriver driver : drivers) {
            if (driver.isAvailable()) {
                double distance = calculateDistance(pickupLocation, driver.getCurrentLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestDriver = driver;
                }
            }
        }
        return nearestDriver;
    }

    private double calculateDistance(Location loc1, Location loc2) {
        // Haversine formula to calculate distance between two lat/lon points
        double lat1 = loc1.getLatitude();
        double lon1 = loc1.getLongitude();
        double lat2 = loc2.getLatitude();
        double lon2 = loc2.getLongitude();

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return 6371 * c; // Radius of earth in kilometers
    }
}
