openapi-generator-cli generate -i openapi.json -g java -o sdk/java --additional-properties=generateBuilders=true,hideGenerationTimestamp=true
cd sdk/java
mvn clean install