FROM nginx:1.23.3

LABEL org.opencontainers.image.title="city-management-frontend"
LABEL org.opencontainers.image.authors="wiktor czertybok"
LABEL org.opencontainers.image.url="https://github.com/kasztanators/Internet-serice-architectures"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="frontend service"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/city-management-frontend /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
