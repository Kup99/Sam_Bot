
FROM amazoncorretto:17-alpine-jdk

WORKDIR /opt/app

ARG JAR_FILE=target/kafka-0.0.1-SNAPSHOT.jar

COPY ./target/kafka-0.0.1-SNAPSHOT.jar /app/kafka.jar

EXPOSE 8383

CMD ["java", "-jar", "/app/kafka.jar"]