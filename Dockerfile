FROM openjdk:21-jdk-slim

WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw package

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]
