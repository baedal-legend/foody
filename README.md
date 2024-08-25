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
