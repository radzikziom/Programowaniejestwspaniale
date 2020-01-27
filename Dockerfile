FROM tomcat:alpine

RUN mkdir /home/readouts

WORKDIR /usr/local/tomcat/webapps

COPY target/tyrakaServer.war .