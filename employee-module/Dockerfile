FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY ./target/employee-module-0.0.1-SNAPSHOT.jar /opt/app/employee-module.jar
ENTRYPOINT ["java", "-jar", "/opt/app/employee-module.jar"]
CMD ["--spring.profiles.active=prod"]