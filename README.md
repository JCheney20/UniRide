
# UniRide Backend

This is a simple Spring Boot application that provides a backend for a ride-hailing service.

## Project Structure

- `build.gradle`: The Gradle build file that defines the project dependencies.
- `src/main/java/com/uniride`:
    - `UniRideApplication.java`: The main application class to start the Spring Boot application.
    - `controller`:
        - `RideController.java`: The REST controller that handles incoming ride requests.
    - `model`:
        - `Driver.java`: The data model for a driver.
        - `Location.java`: A simple class to represent a geographical location.
        - `RideRequest.java`: The data model for a ride request.
        - `User.java`: The data model for a user.
    - `service`:
        - `DriverService.java`: The service that manages driver locations and finds the nearest driver.
        - `NotificationService.java`: A placeholder service to simulate sending requests to drivers.

## How to Run

1. **Build the project:**

   ```bash
   ./gradlew build
   ```

2. **Run the application:**

   ```bash
   ./gradlew bootRun
   ```

The application will start on port 8080.

## API Endpoints

### Request a Ride

- **URL:** `/api/ride/request`
- **Method:** `POST`
- **Body:**

  ```json
  {
    "userId": "123",
    "pickupLocation": {
      "latitude": 34.0522,
      "longitude": -118.2437
    },
    "dropoffLocation": {
      "latitude": 34.0622,
      "longitude": -118.2537
    }
  }
  ```

- **Success Response:**

  - **Code:** 200 OK
  - **Content:** `Ride request sent to the nearest driver.`

- **Error Response:**

  - **Code:** 400 Bad Request
  - **Content:** `No available drivers found.`
