FROM adoptopenjdk:16-jre
COPY target/CovidVaccineMgmt*.jar   /app.jar
CMD java -jar /app.jar