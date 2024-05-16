FROM openjdk:22

ARG JAR_FILE=target/*.jar
COPY target/firstjobapp-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

