FROM openjdk:17
ADD target/spring-chat-0.0.1-SNAPSHOT.jar spring-chat-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","spring-chat-0.0.1-SNAPSHOT.jar"]