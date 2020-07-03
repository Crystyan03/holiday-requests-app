FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY ./target/vacation-request-module-0.0.1-SNAPSHOT.jar /opt/app/vacation-module.jar
ENTRYPOINT ["java", "-jar", "/opt/app/vacation-module.jar"]
CMD ["--spring.profiles.active=prod"]