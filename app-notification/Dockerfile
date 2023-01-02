FROM maven:3.8.3-openjdk-17
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
WORKDIR /app-notification
COPY . .
RUN mvn clean install
EXPOSE 8082
CMD ["mvn", "spring-boot:run"]
