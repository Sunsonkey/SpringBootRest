FROM openjdk:17

WORKDIR /app

EXPOSE 8080

COPY target/SpringBootRest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]