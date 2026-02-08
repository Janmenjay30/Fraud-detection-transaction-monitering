# Run this script to start both services in separate windows

echo "Starting Transaction Producer..."
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd transaction-producer; ./mvnw spring-boot:run"

echo "Starting Transaction Service..."
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd transaction-service; ./mvnw spring-boot:run"

echo "Both services are starting in new windows."
