FROM openjdk:21-jdk-alpine
MAINTAINER pilovr.com
COPY target/docker-java-jar-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
