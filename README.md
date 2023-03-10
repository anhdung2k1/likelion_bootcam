# Docker command
1. Build một image<br/>
```docker build -t <tên image> .```
2. Chạy một image<br/>
```docker run --name <tên container>-p -8080:8080 <tên image>```<br/>-p 8080:8080: là mapping cổng 8080 của container với cổng 8080 của máy<br/>
3. Tạo tag từ image<br/>
```docker tag <tên image> <account name>/<tên repository>:<tagname>```
4. Push lên Docker Hub<br/>
```docker push <account name>/<tên repository>:<tagname>```
5. Pull image từ Docker Hub<br/>
```docker pull <account name>/<tên repository>:<tagname>```
6. Kiểm tra tất cả Image hiện có trong Docker<br/>
```docker image ls```
7. Dừng Image 1 container<br/>
```docker stop <tên container>```
8. Liệt kê tất cả các container đang chạy. Khi sử dụng các tham số -a/-all : liệt kê tất cả các container, kể cả đang chạy hay kết thúc -q/-quite: chỉ liệt kê các id của container <br/>
```docker ps -a/-all```
```docker ps -q/-quite```
9. Hiển thị logs của một container<br/>
```docker logs --follow <tên container>```
10. Liệt kê các volumn container đang sử dụng<br/>
```docker volumn ls```
11. Xóa 1 hay nhiều container<br/>
```docker rm <list_container_name_or_id>```
12. Xóa 1 hay nhiều images<br/>
```docker rmi <list_name_id>```
13. Stop 1 hay nhiều container hoặc để kill 1 container<br/>
```docker stop <list_container_name_or_id>```
#Docker compose
14. Build Docker Compose
```docker-compose up```
15. Remove Docker Compose - Shut Down Docker Compose
```docker-compose down -v```
# Config Dockerfile
	-- FROM <base_image>:<phiên bản>: Câu lệnh bắt buộc phải có
	-- RUN <Câu_lệnh>: Chạy 1 command cho việc cài đặt các công cuộc cần thiết cho Image
	-- ENV <tên_biến>: định nghĩa biến môi trường trong Container
	-- ENTRYPOINT <câu_lệnh>: định nghĩa những command mặc định, cái mà sẽ được chạy khi container running
	-- VOLUME <tên_thư_mục>: dùng để truy cập hoặc liên kết một thư mục nào trong Container
# Kafka Bitnami
16. Check all topics: Navigate to kafka-topics.sh directory by
```
cd var
cd opt
kafka-topics.sh --list --bootstrap-server localhost:9092
```
# Tạo file build bỏ qua mọi test<br/>
```mvn clean package -DskipTests```

# Microservices
1. Tạo 1 project chứa <br/>
```mvn archetype:generate -DgroupId=com.likelion -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false```


