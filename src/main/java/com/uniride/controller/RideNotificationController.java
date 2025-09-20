package com.uniride.controller;

import com.uniride.model.RideRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class RideNotificationController {

    @MessageMapping("/ride-request")
    @SendTo("/topic/ride-requests")
    public RideRequest sendRideRequest(RideRequest rideRequest) {
        return rideRequest;
    }
}
