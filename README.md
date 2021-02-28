# Kafka Streams State Store Example
The definition of the repository is here.

https://medium.com/@gokhan.gurgec/using-apache-kafka-like-database-with-kafkastreams-processor-api-and-statestore-180bb4b5f9e5

## Requirements and Dependencies

- Kafka Cluster
  
- Java 11

- Spring Boot 2.4.3

- Spring Kafka Library

- application.yml
    ```
    kafka:
  bootstrapAddress: http://localhost:9092
  topics:
    msgOrderLocation:
      name: orderLocation
  streams:
    applicationId: orderLocationApplication
    stateStoreName: orderLocationStore
    ```
## Running the application
```./gradlew clean bootRun```
