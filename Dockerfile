# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file (dependencies) and mvnw wrapper to the container
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Grant executable permissions to mvnw (Maven wrapper)
RUN chmod +x mvnw

# Install the Maven dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Build the application using Maven
RUN ./mvnw clean package -DskipTests

# Expose the port the app will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "target/NumberClassfication-0.0.1-SNAPSHOT.jar"]
