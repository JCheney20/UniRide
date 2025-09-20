package com.uniride.service;

import com.uniride.model.StudentDriver;
import com.uniride.model.RideRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendRideRequestToDriver(StudentDriver driver, RideRequest rideRequest) {
        // In a real app, you would target a specific driver, not broadcast to everyone
        System.out.println("Sending ride request to driver: " + driver.getName());
        messagingTemplate.convertAndSend("/topic/ride-requests", rideRequest);
    }
}
