FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/clyvo-care-ai-0.0.1-SNAPSHOT.jar app.jar

RUN useradd -ms /bin/bash springuser

USER springuser

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]