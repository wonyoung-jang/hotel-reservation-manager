FROM openjdk:17
LABEL authors="wonyj"
COPY target/hotel_reservation_manager-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]