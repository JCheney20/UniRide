
package com.uniride.controller;

import com.uniride.model.RideRequest;
import com.uniride.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ride")
public class RideController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/request")
    public ResponseEntity<String> requestRide(@RequestBody RideRequest rideRequest) {
        driverService.requestRide(rideRequest);
        return ResponseEntity.ok("Ride request sent.");
    }
}
