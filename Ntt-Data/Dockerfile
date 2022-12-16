FROM adoptopenjdk/openjdk11:latest
COPY "./target/Ntt-Data-0.0.1-SNAPSHOT.jar" "NTT-DATA.jar"
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "NTT-DATA.jar"  ]