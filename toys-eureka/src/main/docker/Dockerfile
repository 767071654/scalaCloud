FROM openjdk:8
VOLUME /Users/lyf/dockerFile
ADD eureka_2.13-0.1.jar app.jar
EXPOSE 8021
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]