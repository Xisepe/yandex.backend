FROM openjdk:17.0.1-jdk-slim

#EXPOSE 8080

WORKDIR /opt/app

ADD src ./src
ADD gradle/ ./gradle
COPY build.gradle ./build.gradle
COPY settings.gradle ./settings.gradle
COPY gradlew ./gradlew
COPY gradlew.bat ./gradlew.bat

RUN ./gradlew clean bootJar

#ENV JAR_FILE=build/libs/*SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "./build/libs/yandex-lavka-0.0.1-SNAPSHOT.jar"]
