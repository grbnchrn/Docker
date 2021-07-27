#
# Build stage
#
FROM maven:3.6.3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/app/target/simple-webapp-spring-boot-1.0-SNAPSHOT.jar /usr/local/lib/SimpleSpringBootWebApp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/SimpleSpringBootWebApp.jar"]
