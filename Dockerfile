# Use a minimal base image
FROM openjdk:11-jre-slim

# Add a non-root user
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Add metadata
LABEL maintainer="spring_rest_backend"

# Set a working directory
WORKDIR /app

# Copy the JAR file into the container
COPY --chown=appuser:appgroup target/application_rest-0.0.1-SNAPSHOT.jar app.jar

# Switch to non-root user
USER appuser

# Expose the application port
EXPOSE 8383

# Define the entry point
ENTRYPOINT ["java", "-jar", "/app/app.jar"]