FROM openjdk:21

WORKDIR /app

COPY . /app

EXPOSE 8080


RUN ls /app


CMD ["java", "-jar", "../app/build/libs/platform-0.0.1-SNAPSHOT.jar"]