FROM eclipse-temurin:17-jre-focal

COPY ./build/libs/*.jar app.jar

ENV TZ=Asia/Seoul

ENTRYPOINT ["java","-jar","/app.jar"]