
package com.uniride.model;

import com.uniride.enums.EmergencyEventType;

import java.time.LocalDateTime;

public class EmergencyEvent {
    private String eventId;
    private String tripId;
    private EmergencyEventType eventType;
    private LocalDateTime timestamp;

    // Getters and Setters

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public EmergencyEventType getEventType() {
        return eventType;
    }

    public void setEventType(EmergencyEventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
