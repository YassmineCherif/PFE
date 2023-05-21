FROM openjdk:8
COPY ./target/FeatureService-0.0.1-SNAPSHOT.jar FeatureService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","FeatureService-0.0.1-SNAPSHOT.jar"]