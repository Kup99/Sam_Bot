# Используем официальный образ Java
FROM openjdk:11-jre-slim

# Устанавливаем рабочий каталог
WORKDIR /app

# Копируем JAR файл в контейнер
COPY ./target/currencyRateParser-0.0.1-SNAPSHOT.jar /app/currencyRateParser.jar

# Запускаем приложение
CMD ["java", "-jar", "/app/currencyRateParser.jar"]
