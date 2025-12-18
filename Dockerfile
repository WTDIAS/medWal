# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia o código para dentro do container
COPY . .

# Compila e gera o .jar
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia apenas o .jar gerado da etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Porta exposta
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
