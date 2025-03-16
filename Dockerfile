FROM openjdk:21-jdk-slim

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src/ src/

RUN ./mvnw clean package

RUN cp target/*.jar app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]
