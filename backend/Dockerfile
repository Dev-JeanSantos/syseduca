FROM openjdk:17-oracle
EXPOSE 8080
ADD /target/syseduca-0.0.1-SNAPSHOT.jar syseduca.jar
ENTRYPOINT ["java", "-jar","syseduca.jar"]
#ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=dev","-jar","syseduca.jar"]