FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
