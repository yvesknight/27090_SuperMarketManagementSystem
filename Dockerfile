FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY src/ ./src/
COPY MANIFEST.MF .

RUN mkdir -p out && \
    javac -d out src/*.java && \
    jar cfm SupermarketSystem.jar MANIFEST.MF -C out .

CMD ["java", "-jar", "SupermarketSystem.jar"]
