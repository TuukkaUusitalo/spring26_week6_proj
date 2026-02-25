FROM maven:latest
LABEL authors="tuukkauusitalo"

WORKDIR /app

COPY pom.xml .

COPY . /app

RUN mvn package

CMD ["java", "jar", "target/calc.jar"]