FROM eclipse-temurin:17
LABEL maintainer="mdomingu@mail.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dan-ofertas-precios.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/dan-ofertas-precios.jar"]