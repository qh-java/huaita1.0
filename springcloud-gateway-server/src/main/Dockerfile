# 基于哪个镜像
FROM java:8
# 将本地文件夹挂载到当前容器
VOLUME /tmp
# 拷贝文件到容器，handcuffs-reg-0.0.1-SNAPSHOT.jar这里是maven打包后的名字
COPY springcloud-gateway-server.jar gateway.jar
#类似于执行 linux指令
#RUN mkdir /opt/app
#类似于linux copy指令
#COPY demo-docker.jar /opt/app/
RUN bash -c 'touch /gateway.jar'
EXPOSE 8088
# 配置容器启动后执行的命令
ENTRYPOINT ["java", "-jar", "gateway.jar", "--spring.profiles.active=dev", "--server.port=8000", "> /log/app.log"]
#CMD ["java", "-jar", "/opt/app/demo-docker.jar"]