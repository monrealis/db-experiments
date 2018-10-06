#!/bin/bash

mvn liquibase:update -P mysql
mvn liquibase:update -P postgres
mvn liquibase:update -P vertica
