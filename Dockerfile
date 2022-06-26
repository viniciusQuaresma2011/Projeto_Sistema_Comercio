

FROM openjdk:11
ADD target/ProjetoBasico-0.0.1-SNAPSHOT.jar ProjetoBasico-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ProjetoBasico-0.0.1-SNAPSHOT.jar"]
