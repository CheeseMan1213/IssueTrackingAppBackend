# Pulls the base container image for OpenJDK 11 from Docker hub. 
FROM openjdk:11-jdk
# Places the most recently built JAR file into the container environment.
COPY ./build/libs/IssueTrackingAppBackend-0.0.1-SNAPSHOT.jar IssueTrackingAppBackend-0.0.1-SNAPSHOT.jar
# Exposes port 8080. This is important. It must match the port stated in the application.properties file.
EXPOSE 8080:8080
# Used the command 'CMD' to run the app on container start up.
# Remember:
# RUN = Executes shell commands during the process of building the image.
# These commands do not run on container start up, only for the image build.
# ENTRYPOINT = Sets commands to run on container startup that you cannot overwright.
# CMD = Sets commands to run on container startup that may be overwrighten.
CMD ["java", "-jar", "IssueTrackingAppBackend-0.0.1-SNAPSHOT.jar"]
