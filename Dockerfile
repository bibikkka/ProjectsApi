FROM openjdk:18
WORKDIR /
ADD build/libs/ProjectsApi-0.0.1-SNAPSHOT.jar ProjectsApi-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar ProjectsApi-0.0.1-SNAPSHOT.jar
