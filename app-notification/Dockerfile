FROM openjdk:17-alpine
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
COPY target/app-notification*.jar app-notification.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app-notification.jar"]