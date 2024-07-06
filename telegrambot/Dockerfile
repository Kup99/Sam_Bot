
FROM amazoncorretto:21-alpine-jdk

WORKDIR /opt/app

ARG JAR_FILE=target/telegrambot-0.0.1-SNAPSHOT.jar

# Убедитесь, что путь к файлу и его имя правильные
COPY ./target/telegrambot-0.0.1-SNAPSHOT.jar /app/telegrambot.jar

EXPOSE 8181

# Проверьте, что путь в CMD соответствует местоположению файла
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006", "-jar", "/app/telegrambot.jar"]
