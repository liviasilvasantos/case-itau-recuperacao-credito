FROM openjdk:17-alpine
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
COPY target/app-debt*.jar app-debt.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app-debt.jar"]