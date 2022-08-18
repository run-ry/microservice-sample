#!/usr/bin/env bash

echo  "Package building..."
mvn clean install

# Todo: kill app before execute below (ps , kill -9 xxx xxx)

echo "Run discovery server"
cd discovery-server
java -jar target/discovery-server*.jar &


echo "Run config server"
cd ../config-server
java -jar target/config-server*.jar &

echo "Run auth service"
cd ../auth-service
java -jar target/auth-service*.jar &

echo "Run user service"
cd ../user-service
java -jar target/user-service*.jar &

echo "Run book service"
cd ../book-service
java -jar target/book-service*.jar &

echo "Run reservation service"
cd ../reservation-service
java -jar target/reservation-service*.jar &

echo "Run gateway server"
cd ../gateway-server
java -jar target/gateway-server*.jar &