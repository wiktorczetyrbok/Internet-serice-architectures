FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="city-management-gateway"
LABEL org.opencontainers.image.authors="wiktor czetyrbok"
LABEL org.opencontainers.image.url="https://github.com/kasztanators/Internet-serice-architectures"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="city management gateway"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_DATASOURCE_PASSWORD=password


ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_DEFER_DATASOURCE_INITIALIZATION=true

ENV ISA_GATEWAY_HOST=http://city-management-gateway:8080/
ENV ISA_CITY_URL=http://city-service:8080/
ENV ISA_CITIZEN_URL=http://citizen-service:8080/

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/city-management-gateway-${VERSION}.jar /opt/city-management-gateway/city-management-gateway.jar

CMD ["java", "-jar", "/opt/city-management-gateway/city-management-gateway.jar"]
