FROM openjdk:8
ADD target/eurekaservice.jar eurekaservice.jar
EXPOSE 8079
ENTRYPOINT ["java", "-jar", "eurekaservice.jar"]