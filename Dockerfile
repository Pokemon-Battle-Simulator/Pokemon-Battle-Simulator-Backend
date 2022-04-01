# declare the base image - here is a light weight JDK 8 setup
FROM openjdk:8-jdk-alpine

# copy the generate JAR into the container to run
COPY /target/Pokemon-Battle-Simulator-Backend-0.0.1-SNAPSHOT.jar Pokemon-Battle-Simulator-Backend-0.0.1-SNAPSHOT.jar

# Expose port 5000 of the container
EXPOSE 5000

# Run the JAR when we run the container, thus executing the app
ENTRYPOINT ["java", "-jar", "Pokemon-Battle-Simulator-Backend-0.0.1-SNAPSHOT.jar"]
