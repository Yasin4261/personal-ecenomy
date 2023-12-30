FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/personel-economy-0.0.1-SNAPSHOT.jar app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080

LABEL authors="Yasin"
