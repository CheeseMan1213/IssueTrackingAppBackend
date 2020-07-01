FROM openjdk:11-jdk
COPY ./build/libs/IssueTrackingAppBackend-0.0.1-SNAPSHOT.jar IssueTrackingAppBackend-0.0.1-SNAPSHOT.jar
EXPOSE 8080:8080
CMD ["java", "-jar", "IssueTrackingAppBackend-0.0.1-SNAPSHOT.jar"]