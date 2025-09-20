package com.uniride.external;

import org.springframework.stereotype.Service;

@Service
public class ExternalMapAPIImpl implements ExternalMapAPI {

    @Override
    public void getDirections() {
        System.out.println("Getting directions...");
    }

    @Override
    public void calculateDistance() {
        System.out.println("Calculating distance...");
    }

    @Override
    public void getLocationDetails() {
        System.out.println("Getting location details...");
    }

    @Override
    public void provideTurnByTurn() {
        System.out.println("Providing turn-by-turn directions...");
    }

    @Override
    public void navigateRealTimeGPS() {
        System.out.println("Navigating with real-time GPS...");
    }
}
