#!/bin/bash

curl -k https://www.vertica.com/client_drivers/9.1.x/9.1.1-0/vertica-jdbc-9.1.1-0.jar > vertica-jdbc-9.1.1-0.jar
mvn install:install-file -Dfile=vertica-jdbc-9.1.1-0.jar -DgroupId=com.vertica -DartifactId=vjdbc9 -Dversion=9.1.1-0 -Dpackaging=jar
