FROM maven:3.8.3-openjdk-17
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
WORKDIR /app-payment
COPY . .
RUN mvn clean install
EXPOSE 8085
CMD ["mvn", "spring-boot:run"]
