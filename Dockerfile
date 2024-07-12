# Maven ile uygulamayı derlemek için kullanılan aşama
FROM maven:3.8.5-openjdk-17 AS build

# Uygulama kodlarını kopyala
COPY . .

# Uygulamayı derle ve paketle, testleri atla
RUN mvn clean package -DskipTests

# OpenJDK 17 tabanlı bir Java çalışma zamanı kullanarak uygulamayı çalıştır
FROM openjdk:17.0.1-jdk-slim

# MySQL JDBC sürücüsünü yükle
RUN apt-get update && apt-get install -y default-libmysqlclient-dev

# Uygulama JAR dosyasını kopyala
COPY --from=build /target/personel-economy-0.0.1-SNAPSHOT.jar /app/app.jar

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Uygulama tarafından kullanılacak olan portu belirle
EXPOSE 8080

# Oluşturan kişinin bilgisini etiketle
LABEL author="Yasin"
