FROM openjdk:8
ADD target/configservice.jar configservice.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "configservice.jar"]