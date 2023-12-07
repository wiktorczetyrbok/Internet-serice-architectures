FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="city-service"
LABEL org.opencontainers.image.authors="wiktor czetyrbok"
LABEL org.opencontainers.image.url="https://github.com/kasztanators/Internet-serice-architectures"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="city service"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:city
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV CITIZEN_URL=http://localhost:8081

EXPOSE 8080


COPY target/city-service-${VERSION}.jar /opt/city-service/city-service.jar

CMD ["java", "-jar", "/opt/city-service/city-service.jar"]
