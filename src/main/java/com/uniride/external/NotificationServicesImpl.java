package com.uniride.external;

import org.springframework.stereotype.Service;

@Service
public class NotificationServicesImpl implements NotificationServices {

    @Override
    public void sendPushNotification() {
        System.out.println("Sending push notification...");
    }

    @Override
    public void sendSMSAlert() {
        System.out.println("Sending SMS alert...");
    }

    @Override
    public void sendVerificationCode() {
        System.out.println("Sending verification code...");
    }

    @Override
    public void sendTripUpdates() {
        System.out.println("Sending trip updates...");
    }

    @Override
    public void sendSMSToEmergencyContacts() {
        System.out.println("Sending SMS to emergency contacts...");
    }
}
