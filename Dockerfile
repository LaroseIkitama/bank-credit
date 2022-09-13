FROM openjdk:11
LABEL maintainer="Larose imdev242@gmail.com"
EXPOSE 8080
ADD target/bank_credit.jar bank_credit.jar
ENTRYPOINT ["java", "-jar", "bank_credit.jar"]