# Estágio 1: Build da aplicação
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Dá permissão de execução ao wrapper do maven
RUN chmod +x mvnw
# Baixa as dependências offline (otimiza cache do docker)
RUN ./mvnw dependency:go-offline
COPY src ./src
# Compila o projeto ignorando testes para agilizar o build do contêiner
RUN ./mvnw clean package -DskipTests

# Estágio 2: Execução
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copia o .jar gerado do estágio anterior
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]