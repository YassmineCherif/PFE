FROM openjdk:8
COPY ./target/CategorieService-0.0.1-SNAPSHOT.jar CategorieService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","CategorieService-0.0.1-SNAPSHOT.jar"]