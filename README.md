Project 실행 방법
===

## docker를 이용한 local postgreSQL 구동
1. .env 파일 작성
```properties
EXPOSE_PORT=
TARGET_PORT=5432
DB_NAME=foody
USER=
PASSWORD=
```

2. docker-compose 구동
```shell
docker compose up -d
```

3. 연결 확인
> jdbc:postgresql://host.docker.internal:5432/foody

4. docker build
```shell
./gradlew jibDockerBuild
```
- 빌드 확인 
```shell
docker images | grep baedal-legend
``` 

5. 빌드 및 실행/종료 관련 script
- 빌드 : [build.sh](docs%2Fbuild.sh)
- Foody 서비스 시작 : [service-up.sh](docs%2Fservice-up.sh)
- Foody 서비스 종료 [service-down.sh](docs%2Fservice-down.sh)
