FROM openjdk:8-jre-slim
VOLUME /tmp
ENV JAR_FILE /beca-service/beca-web/target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]