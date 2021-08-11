FROM openjdk:8-jre-alpine
EXPOSE 8084
COPY target/spring-boot-backend-apirest.jar .
ENTRYPOINT [ "java", "-jar", "spring-boot-backend-apirest.jar" ]



#docker build -t spring-boot-backend-apirest .
#docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6
#docker run -d -p 8089:8089 --name spring-boot-backend-apirest --link mysql-standalone:mysql spring-boot-backend-apirest