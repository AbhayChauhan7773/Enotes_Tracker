FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
COPY certificates/cam.pem /app/cam.pem

RUN keytool -importcert \
    -alias tidb-ca \
    -file /app/cam.pem \
    -keystore /app/tidb-truststore.p12 \
    -storetype PKCS12 \
    -storepass changeit \
    -noprompt

ENV JAVA_TOOL_OPTIONS="-Djavax.net.ssl.trustStore=/app/tidb-truststore.p12 -Djavax.net.ssl.trustStorePassword=changeit -Djavax.net.ssl.trustStoreType=PKCS12"

EXPOSE 10000

CMD ["sh", "-c", "java -Dserver.port=${PORT:-10000} -jar app.jar"]