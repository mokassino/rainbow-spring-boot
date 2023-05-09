# Create a stage for building
FROM maven:3.8.4-openjdk-17 AS build

#WORKDIR /opt

COPY . /opt

WORKDIR /opt/rainbowspringboot

# Generate .jar file
RUN mvn clean package 

# Create a new stage for deploy
FROM openjdk:17-ea-slim

WORKDIR /opt/

#Copy the .jar file from the previous stage build into current directory
COPY --from=build /opt/rainbowspringboot/target/rainbowspringboot-0.0.1-SNAPSHOT.jar ./rainbowspringboot.jar

#Execute the app using java -jar
CMD ["java", "-jar", "rainbowspringboot.jar"]
