#!/bin/bash

java -jar configservice/target/configservice.jar &
java -jar gatewayservice/target/gatewayservice.jar &
java -jar brokerservice/target/brokerservice.jar &
java -jar notificationservice/target/notificationservice-0.0.1-SNAPSHOT.jar &
java -jar oracledatasync/target/oracledatasync.jar &