#!/bin/bash
echo 'build all 3 modules'
cd employee-module
mvn clean install -DskipTests
cd ../vacation-request-module
mvn clean install -DskipTests
cd ../vacation-request-ui
mvn clean install -DskipTests