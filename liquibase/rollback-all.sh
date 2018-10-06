#!/bin/bash

mvn liquibase:rollback -Dliquibase.rollbackCount=10 -P mysql
mvn liquibase:rollback -Dliquibase.rollbackCount=10 -P postgres
mvn liquibase:rollback -Dliquibase.rollbackCount=10 -P vertica
