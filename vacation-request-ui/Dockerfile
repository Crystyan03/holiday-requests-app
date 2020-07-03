FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY ./target/vacation-request-ui-0.0.1-SNAPSHOT.jar /opt/app/vacation-request-ui.jar
ENTRYPOINT ["java", "-jar", "/opt/app/vacation-request-ui.jar"]
CMD ["--spring.profiles.active=prod"]