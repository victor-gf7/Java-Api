FROM openjdk:11

ARG PROFILE
ARG ADITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/spring-boot*.jar java_api_v3.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADITIONAL_OPTS} -jar java_api_v3.jar --spring.profiles.active=${PROFILE}