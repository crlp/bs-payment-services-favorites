FROM openjdk:11-jre
COPY target/payment-services-favorites*SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/opt/app.jar"]