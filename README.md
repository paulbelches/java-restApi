# java-restApi

This is a Java REST API using Spring. It recovers info from sites sucha as  itunes and tvmaze, and returns it in a json format.

## Dependencies
    Spring Web      https://start.spring.io
    Json Simple     Version 1.1.1
    Gradle

## Setup

1. Install Gradle. 

2. (Optional) Configure port, modify the application.properties file in /java-restApi/rest-service/build/resources/main/

## How to build

1. Clone the repository.

        $ git clone https://github.com/paulbelches/java-restApi.git

2. Change directory to project

        $ cd java-restApi/rest-service

3. Build

        $ ./gradlew build

4. Run

        $ java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar
          
4. To test the rest API you can execute, in another terminal
        
        $ curl http://localhost:9000/search?term=metallica
          
## License

Mit License Copyright (c) 2021 Paul Belches.