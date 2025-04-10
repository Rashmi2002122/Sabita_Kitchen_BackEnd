FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


From openjdk:17.0.1-jdk-slim
COPY --from=build /target/Sabita_Cloud_Kitchen_Back_Service-0.0.1-SNAPSHOT.jar Sabita_Cloud_Kitchen_Back_Service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Sabita_Cloud_Kitchen_Back_Service.jar"]

ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"