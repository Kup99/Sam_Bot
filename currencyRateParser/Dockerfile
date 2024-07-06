FROM amazoncorretto:21-alpine-jdk

WORKDIR /opt/app

ARG JAR_FILE=target/currencyRateParser-0.0.1-SNAPSHOT.jar

# Копируем JAR файл в контейнер
COPY ./target/currencyRateParser-0.0.1-SNAPSHOT.jar /app/currencyRateParser.jar

# Запускаем приложение
CMD ["java", "-jar", "/app/currencyRateParser.jar"]
