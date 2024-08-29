FROM openjdk:17
EXPOSE 8080
COPY target/player-reevoo-image.jar player-reevoo-image.jar
ENTRYPOINT [ "java", "-jar", "/player-reevoo-image.jar" ]