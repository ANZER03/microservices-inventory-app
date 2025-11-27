# Use the lightweight Java Runtime Environment (JRE) for deployment
FROM eclipse-temurin:21-jre-jammy

# Define the working directory inside the container
WORKDIR /app

# IMPORTANT: The JAR file must exist on the host where you run 'docker build'
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8761

# Command to run the JAR, using optimized JVM settings
# MaxRAMPercentage=75.0 tells the JVM to use up to 75% of the container's available memory.
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]