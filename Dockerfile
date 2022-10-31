FROM openjdk:11

COPY docs/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8090