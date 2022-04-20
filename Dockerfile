FROM tomcat:10.1.0-jdk11-temurin

MAINTAINER osama "amazonya2022@gmail.com"

EXPOSE 8080

RUN rm -rf /user/local/tomcat/webapps/*

COPY ./target/amazonya.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]