FROM openjdk:17
MAINTAINER "krishna"
COPY target/rest-app.jar /usr/app/rest-app.jar
WORKDIR /usr/app/
EXPOSE 8080
ENTRYPOINT [ "java","-jar", "rest-app.jar" ]