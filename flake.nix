{
  description = "UniRide project with Java backend and React Native frontend";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-23.11"; # Use a stable Nixpkgs channel
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils, ... }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};

        # Define a specific JDK version
        jdk = pkgs.jdk17; # Assuming JDK 17 for Spring Boot
        nodejs = pkgs.nodejs_20; # Assuming Node.js 20 LTS
        gradle = pkgs.gradle;

      in
      {
        devShells.default = pkgs.mkShell {
          buildInputs = [
            jdk
            nodejs
            gradle
            pkgs.gnused
            pkgs.gawk
            pkgs.coreutils
          ];

          shellHook = ''
            echo "Entering UniRide development shell..."
            echo "JDK version: $(java -version 2>&1 | head -n 1)"
            echo "Node.js version: $(node -v)"
            echo "npm version: $(npm -v)"
            echo "Gradle version: $(gradle -v --short)"

            # Navigate to the frontend directory and install dependencies
            echo "Installing frontend dependencies..."
            (cd UniRide && npm install)

            # Ensure Gradle wrapper is present (if not already generated)
            echo "Ensuring Gradle wrapper..."
            (cd /home/justin/Documents/CSC312/SE/Project/UniRide && gradle wrapper)

            echo "Development shell ready."
            echo "To run backend: ./gradlew bootRun"
            echo "To run frontend: cd UniRide && npx expo start --dev-client (or use 'nix run .#frontend' in a separate terminal)"
          '';
        };

        # Define an app to run the backend
        apps.backend = {
          type = "app";
          program = "${
            pkgs.writeScript "run-backend" ''
              #!${pkgs.bash}/bin/bash
              export JAVA_HOME=${jdk}
              export PATH=$JAVA_HOME/bin:$PATH
              cd /home/justin/Documents/CSC312/SE/Project/UniRide
              ./gradlew bootRun
            ''
          }";
        };

        # Define an app to run the frontend
        apps.frontend = {
          type = "app";
          program = "${
            pkgs.writeScript "run-frontend-app" ''
              #!${pkgs.bash}/bin/bash

              echo "Setting up frontend environment..."
              export PATH=${nodejs}/bin:$PATH
              export PATH=${pkgs.gnused}/bin:$PATH
              export PATH=${pkgs.gawk}/bin:$PATH
              export PATH=${pkgs.coreutils}/bin:$PATH

              cd /home/justin/Documents/CSC312/SE/Project/UniRide/UniRide

              echo "Installing frontend dependencies (if not already installed)..."
              npm install

              echo "Attempting to get local IP address..."
              LOCAL_IP=$(hostname -I | awk '{print $1}')

              if [ -z "$LOCAL_IP" ]; then
                echo "Could not automatically determine local IP address. Please set it manually."
                exit 1
              fi

              echo "Detected local IP: $LOCAL_IP"
              PASSENGER_FILE="/home/justin/Documents/CSC312/SE/Project/UniRide/UniRide/app/(tabs)/passenger.tsx"
              WEBSOCKET_SERVICE_FILE="/home/justin/Documents/CSC312/SE/Project/UniRide/UniRide/hooks/WebSocketService.ts"

              # Use sed to replace the placeholder IP address.
              sed -i "s#http://192.168.1.10:8080#http://$LOCAL_IP:8080#g" "$PASSENGER_FILE"
              sed -i "s#http://192.168.1.10:8080#http://$LOCAL_IP:8080#g" "$WEBSOCKET_SERVICE_FILE"

              echo "Updated $PASSENGER_FILE with IP: $LOCAL_IP"
              echo "Updated $WEBSOCKET_SERVICE_FILE with IP: $LOCAL_IP"

              echo "Starting frontend development server..."
              npx expo start --dev-client
            ''
          }";
        };

        # Define a default app (optional, but good for `nix run`)
        apps.default = self.apps.${system}.backend;
      }
    );
}
