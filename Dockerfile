FROM --platform=linux/amd64 bellsoft/liberica-openjdk-alpine:17

#FROM bellsoft/liberica-openjdk-alpine:17

#ARG JAR_FILE=build/libs/*.jar
##
#COPY ${JAR_FILE} app.jar

COPY build/libs/Board-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]