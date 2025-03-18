# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container (adjust based on your build tool)
COPY target/TestDocker-0.0.1-SNAPSHOT.war app.jar

# Expose the port that the app will run on
EXPOSE 8001

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]