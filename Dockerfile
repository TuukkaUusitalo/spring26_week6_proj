FROM maven:latest
LABEL authors="tuukkauusitalo"

WORKDIR /app

COPY pom.xml .


COPY src ./src

RUN mvn -B -U clean package

# 2: Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/lecture25_02_26-1.0-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
