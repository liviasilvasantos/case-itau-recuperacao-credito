FROM openjdk:17-alpine
LABEL Lívia Silva Santos <liviasilvasantos@gmail.com>
COPY target/app-catalog*.jar app-catalog.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app-catalog.jar"]