# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /usr/app

# Copy the JAR file from the local target folder into the container
COPY ./target/TestDocker-1.0-SNAPSHOT.jar app.jar

# Expose the port (only needed if your app runs on a specific port, like Spring Boot)
#EXPOSE 8080

# Run the JAR file using Java
ENTRYPOINT ["java", "-jar", "app.jar"]