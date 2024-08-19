FROM amazoncorretto:17

ARG JAR_FILE=api/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar & tail -f /dev/null"]