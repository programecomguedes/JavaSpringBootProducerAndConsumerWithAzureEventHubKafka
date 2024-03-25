FROM gradle:8.6.0-jdk17 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml para o contêiner
COPY build.gradle .
COPY settings.gradle .

# Copia todos os arquivos do projeto para o contêiner
COPY src ./src

# Executa o build da aplicação
RUN gradle clean build

# Define uma nova imagem base
FROM eclipse-temurin:17.0.10_7-jre-jammy

VOLUME /tmp /logs
RUN groupadd -r appuser && useradd -r -g appuser -s /bin/false -b /home appuser

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado durante o build para o contêiner
COPY --from=build /app/build/libs/*azurekafkaconsumer-*.jar /app/app.jar

RUN chown -R appuser:appuser /app/
USER appuser

# Expõe a porta em que a aplicação vai ser executada
EXPOSE 8082

CMD ["java", "-jar", "app.jar"]