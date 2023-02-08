FROM maven:3.8.4-eclipse-temurin-17-alpine as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package

# Use Eclipse-Temurin Alpine for base image.
FROM eclipse-temurin:17-alpine

# Copy the jar to the production image from the builder stage.
COPY --from=builder /app/target/cicd2023*.jar /cicd2023.jar

# Run the web service on container startup.
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/cicd2023.jar"]
