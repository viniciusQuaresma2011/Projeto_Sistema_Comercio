FROM maven:3.8.2-jdk-11

COPY . .

RUN mvn clean package

FROM openjdk:11
ARG JAR_FILE=target/ProjetoBasico-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
