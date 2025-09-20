import React, { useState } from 'react';
import { StyleSheet, TouchableOpacity, Text, View, Platform } from 'react-native'; // Added Platform
import * as Location from 'expo-location';
import MapView, { Marker } from 'react-native-maps';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';

export default function HomeScreen() {
  const [location, setLocation] = useState<Location.LocationObject | null>(null);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);

  const fetchLocation = async () => {
    let { status } = await Location.requestForegroundPermissionsAsync();
    if (status !== 'granted') {
      setErrorMsg('Permission to access location was denied');
      return;
    }

    let location = await Location.getCurrentPositionAsync({});
    setLocation(location);
    if (location) {
      sendLocationToBackend(location);
    }
  };

  const sendLocationToBackend = async (location: Location.LocationObject) => {
    try {
      // IMPORTANT: Replace 'YOUR_LOCAL_IP' with your computer's local IP address.
      // On macOS/Linux, run `ip addr` or `ifconfig`. On Windows, run `ipconfig`.
      const backendUrl = 'http://192.168.1.20:8080/api/ride/request';

      const rideRequest = {
        // Sending a dummy passenger ID. This would be the logged-in user's ID in a real app.
        passenger: { id: 1 },
        pickupLocation: {
          latitude: location.coords.latitude,
          longitude: location.coords.longitude,
        },
        // Dummy dropoff for now.
        dropoffLocation: {
          latitude: location.coords.latitude + 0.01,
          longitude: location.coords.longitude + 0.01,
        },
        status: 'PENDING',
      };

      const response = await fetch(backendUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(rideRequest),
      });

      if (!response.ok) {
        const errorText = await response.text();
        throw new Error(`Backend request failed: ${response.status} ${errorText}`);
      }

      const responseData = await response.json();
      console.log('Backend response:', responseData);
      // You could update state here based on the backend's response
    } catch (error) {
      console.error('Error sending location to backend:', error);
      setErrorMsg('Failed to connect to backend. Is it running?');
    }
  };

  return (
    <ThemedView style={styles.container}>
      <ThemedText type="title">UniRide</ThemedText>
      <TouchableOpacity style={styles.button} onPress={fetchLocation}>
        <Text style={styles.buttonText}>Get Location</Text>
      </TouchableOpacity>
      {location && Platform.OS !== 'web' && ( // Conditional rendering for MapView
        <MapView
          style={styles.map}
          initialRegion={{
            latitude: location.coords.latitude,
            longitude: location.coords.longitude,
            latitudeDelta: 0.0922,
            longitudeDelta: 0.0421,
          }}
        >
          <Marker
            coordinate={{
              latitude: location.coords.latitude,
              longitude: location.coords.longitude,
            }}
            title="Your Location"
          />
        </MapView>
      )}
      {errorMsg && <ThemedText>{errorMsg}</ThemedText>}
    </ThemedView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    gap: 20,
  },
  button: {
    backgroundColor: '#007BFF',
    padding: 15,
    borderRadius: 10,
  },
  buttonText: {
    color: '#FFFFFF',
    fontSize: 16,
    fontWeight: 'bold',
  },
  map: {
    width: '100%',
    height: '50%',
  },
});