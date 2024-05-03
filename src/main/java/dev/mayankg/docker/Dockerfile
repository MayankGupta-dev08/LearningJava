# Use the official OpenJDK 17 image from the Docker hub
FROM openjdk:17
# Set the working directory inside the container
WORKDIR /app
# COPY the compiled java application JAR File <user-service.jar> into the container
COPY ./target/user-service.jar /app
# EXPOSE the port <9191> of the container on which application will run
EXPOSE 9191
# Command to run the application <user-service.jar>
CMD ["java", "-jar", "user-service.jar"]