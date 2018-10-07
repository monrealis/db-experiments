#!/bin/bash

mvn liquibase:rollback -Dliquibase.rollbackCount=10 -P vertica
