FROM openjdk:8
COPY ./target/orderService-0.0.1-SNAPSHOT.jar orderService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","orderService-0.0.1-SNAPSHOT.jar"]