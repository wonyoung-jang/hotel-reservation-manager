FROM openjdk:17
LABEL authors="wonyj"
COPY target/Hotel_Reservation_Manager-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]