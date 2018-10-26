#!/bin/bash

EXIT_STATUS=0

./gradlew --stop || EXIT_STATUS=$?
./gradlew clean check assemble -Dgrails.env=test --refresh-dependencies || EXIT_STATUS=$?

exit $EXIT_STATUS
