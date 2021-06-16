FROM openjdk:8
EXPOSE 8080
COPY target/logger-sender.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
