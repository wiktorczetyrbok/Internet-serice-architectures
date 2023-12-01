FROM nginx:1.23.3

LABEL org.opencontainers.image.title="city-management"
LABEL org.opencontainers.image.authors="wiktor czertybok"
LABEL org.opencontainers.image.url="https://github.com/kasztanators/Internet-serice-architectures"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="frontend service"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/city-managment-frontend /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
