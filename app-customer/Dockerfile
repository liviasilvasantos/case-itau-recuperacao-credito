FROM openjdk:17-alpine
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
COPY target/app-customer*.jar app-customer.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app-customer.jar"]