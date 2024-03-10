# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jre-alpine
LABEL author="Nguyen"

#COPY ./api_admin/target/*.jar ./app.jar
COPY ./target/*.jar ./app.jar
COPY res res
COPY cache cache
COPY army2.conf army2.conf
# Chỉnh múi giờ thành múi giờ VN UTC + 7
ENV TZ=Asia/Ho_Chi_Minh
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENTRYPOINT ["java", "-jar", "./app.jar"]