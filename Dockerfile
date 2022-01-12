FROM openjdk:13-jdk-alpine3.10
RUN apk update && apk upgrade && apk add netcat-openbsd && apk add bind-tools
RUN mkdir -p /usr/local/supportshell
ADD target/rest-api-0.0.1-SNAPSHOT.jar /usr/local/iapl/
CMD java  -Dspring.profiles.active=$PROFILE -jar /usr/local/iapl/rest-api-0.0.1-SNAPSHOT.jar