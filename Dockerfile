FROM maven:latest
LABEL authors="tuukkauusitalo"

WORKDIR /app

COPY pom.xml .


COPY src ./src


RUN mvn clean package

CMD ["java", "-jar", "target/lecture25_02_26-1.0-SNAPSHOT.jar"]

