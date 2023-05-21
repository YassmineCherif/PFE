FROM openjdk:8
COPY ./target/ProductService-0.0.1-SNAPSHOT.jar ProductService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","ProductService-0.0.1-SNAPSHOT.jar"]