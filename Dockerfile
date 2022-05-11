#Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

#Information around who maintains the image
LABEL org.opencontainers.image.authors="Buzwe"

# Add the application's jar to the container
COPY target/conversion-0.0.1-SNAPSHOT.jar conversion-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/conversion-0.0.1-SNAPSHOT.jar"]