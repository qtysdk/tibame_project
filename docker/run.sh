docker stop mysql || true
docker rm mysql || true
docker run --name mysql -p 3306:3306 -v `pwd`/my-conf.d:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=my-mysql -d mysql:8 --default-authentication-plugin=mysql_native_password

