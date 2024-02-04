FROM maven:3.9.4-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

# Estágio de execução
FROM openjdk:17-ea-10-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar ./recodeviagensrecode.jar
ENTRYPOINT java -jar recodeviagensrecode.jar



