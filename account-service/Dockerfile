FROM openjdk:17.0.2-jdk-oracle as builder
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17.0.2-jdk-oracle
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

ENTRYPOINT ["java", "-Xms512m", "-Xmx1024m", "org.springframework.boot.loader.JarLauncher"]
