#
# Build Stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Use the OpenJDK 17 image as the base image
FROM openjdk:17
EXPOSE 5005 8080
COPY --from=build /home/app/target /tmp
WORKDIR /tmp
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "BoardStudy-0.0.1-SNAPSHOT.jar"]