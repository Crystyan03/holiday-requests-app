FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY ./target/employee-module-0.0.1-SNAPSHOT.jar /opt/app/employee-module.jar
CMD ["java", "-jar", "-Dspring.datasource.url=jdbc:/172.17.0.3:5432/postgres", "-Dspring.datasource.username=postgres", "-Dspring.datasource.password=mysecretpassword", "/opt/app/employee-module.jar"]