import { Image, StyleSheet, Platform, TouchableOpacity, Alert } from 'react-native';
import React, { useState } from 'react';

import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';

// IMPORTANT: Replace with your machine's local IP address
const API_URL = 'http://192.168.1.10:8080';

export default function PassengerScreen() {
  const [message, setMessage] = useState('');

  const handleRequestRide = async () => {
    try {
      const response = await fetch(`${API_URL}/api/ride/request`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          pickupLocation: {
            latitude: 34.0522,
            longitude: -118.2437,
          },
          // Add other ride request details here
        }),
      });

      const responseText = await response.text();

      if (response.ok) {
        setMessage(responseText);
        Alert.alert('Success', responseText);
      } else {
        setMessage(`Error: ${responseText}`);
        Alert.alert('Error', responseText);
      }
    } catch (error) {
      console.error(error);
      setMessage(`Error: ${error.message}`);
      Alert.alert('Error', 'Could not connect to the server.');
    }
  };

  return (
    <ThemedView style={styles.container}>
      <ThemedText type="title">Passenger Mode</ThemedText>
      <ThemedText>Request a ride and see available drivers.</ThemedText>
      <ThemedView style={styles.buttonContainer}>
        <TouchableOpacity onPress={handleRequestRide} style={styles.button}>
          <ThemedText style={styles.buttonText}>Request Ride</ThemedText>
        </TouchableOpacity>
      </ThemedView>
      {message ? <ThemedText style={styles.message}>{message}</ThemedText> : null}
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
  buttonContainer: {
    marginTop: 20,
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: '100%',
  },
  button: {
    backgroundColor: '#2ecc71',
    padding: 15,
    borderRadius: 5,
    width: '80%',
  },
  buttonText: {
    color: 'white',
    textAlign: 'center',
    fontWeight: 'bold',
  },
  message: {
    marginTop: 20,
    textAlign: 'center',
  },
});
