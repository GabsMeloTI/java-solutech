# Usa a imagem base do Ubuntu
FROM ubuntu:latest

# Define variáveis de ambiente para o Java e Maven
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV MAVEN_HOME=/usr/share/maven
ENV PATH="${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}"

# Atualiza o sistema e instala dependências para o JDK e Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml e todas as dependências do projeto para o contêiner
COPY pom.xml ./
COPY src ./src

# Executa o Maven para construir o projeto
RUN mvn clean install -DskipTests

# Expõe a porta em que a aplicação Spring Boot vai rodar (8080 por padrão)
EXPOSE 8080

# Define o comando para rodar a aplicação
CMD ["java", "-jar", "target/library-0.0.1-SNAPSHOT.jar"]
