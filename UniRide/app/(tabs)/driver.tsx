import { Image, StyleSheet, Platform, TouchableOpacity, Alert } from 'react-native';
import React, { useState, useEffect } from 'react';

import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import WebSocketService from '@/hooks/WebSocketService';

export default function DriverScreen() {
  const [rideRequest, setRideRequest] = useState(null);

  useEffect(() => {
    WebSocketService.connect((newRideRequest) => {
      setRideRequest(newRideRequest);
    });

    return () => {
      WebSocketService.disconnect();
    };
  }, []);

  const handleAccept = () => {
    if (rideRequest) {
      Alert.alert('Ride Accepted', `You have accepted the ride.`);
      setRideRequest(null);
    }
  };

  const handleDecline = () => {
    if (rideRequest) {
      Alert.alert('Ride Declined', `You have declined the ride.`);
      setRideRequest(null);
    }
  };

  return (
    <ThemedView style={styles.container}>
      <ThemedText type="title">Driver Mode</ThemedText>
      {rideRequest ? (
        <ThemedView style={styles.requestContainer}>
          <ThemedText type="subtitle">Incoming Ride Request</ThemedText>
          <ThemedText>From: {JSON.stringify(rideRequest.pickupLocation)}</ThemedText>
          <ThemedView style={styles.buttonContainer}>
            <TouchableOpacity onPress={handleAccept} style={[styles.button, styles.acceptButton]}>
              <ThemedText style={styles.buttonText}>Accept</ThemedText>
            </TouchableOpacity>
            <TouchableOpacity onPress={handleDecline} style={[styles.button, styles.declineButton]}>
              <ThemedText style={styles.buttonText}>Decline</ThemedText>
            </TouchableOpacity>
          </ThemedView>
        </ThemedView>
      ) : (
        <ThemedText>Waiting for ride requests...</ThemedText>
      )}
    </ThemedView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  requestContainer: {
    marginTop: 20,
    padding: 20,
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#ccc',
    width: '100%',
  },
  buttonContainer: {
    marginTop: 20,
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: '100%',
  },
  button: {
    padding: 15,
    borderRadius: 5,
    width: '45%',
  },
  acceptButton: {
    backgroundColor: '#2ecc71',
  },
  declineButton: {
    backgroundColor: '#e74c3c',
  },
  buttonText: {
    color: 'white',
    textAlign: 'center',
    fontWeight: 'bold',
  },
});
