FROM openjdk:8
COPY ./target/eurekaServer-0.0.1-SNAPSHOT.jar eurekaServer-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","eurekaServer-0.0.1-SNAPSHOT.jar"]