FROM openjdk:17-alpine
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
COPY target/app-payment*.jar app-payment.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app-payment.jar"]