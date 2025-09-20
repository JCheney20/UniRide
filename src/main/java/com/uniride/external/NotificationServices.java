
package com.uniride.external;

public interface NotificationServices {
    void sendPushNotification();
    void sendSMSAlert();
    void sendVerificationCode();
    void sendTripUpdates();
    void sendSMSToEmergencyContacts();
}
