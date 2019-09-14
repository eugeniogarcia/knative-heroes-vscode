FROM openjdk:8-jre-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd && apk add curl
RUN mkdir -p /app 
COPY ./target/heroes-0.0.2-SNAPSHOT.jar /app/ 
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005,quiet=y", "-jar", "/app/heroes-0.0.2-SNAPSHOT.jar"]
