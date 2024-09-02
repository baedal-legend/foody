1.Project 상세
===
## 프로젝트 목적 ##
음식점들의 배달 및 포장 주문 관리, 결제, 그리고 주문 내역 관리 기능을 제공하는 플랫폼 개발

## 
## 개발 환경 ##
|분류|상세|
| ---------- | :--------- |
|IDE|IntelliJ|
|Language|Java 17|
|Framework|Spring Boot 3.3.3|
|Repository|H2 In-memory, PostgreSQL 16.4, Redis 7.4|
|Build Tool|Gradle 8.8|
|DevOps - dev|EC2, ECR, ALB, ACM, RDS(PostreSQL), Elastic Cache(Redis), Docker(Jib), Gihub Actions|

## 상세 개발 환경 ##
**Dependencies** 
- Spring Web
- Spring Validation
- Spring Security
- Spring WebFlux (or web-client)
- Spring Data Jpa
- Spring Data Redis
- Spring Kafka
- Spring Cloud Gateway
- Spring Cloud Eureka
- jjwt
- QueryDSL
- Lombok
- JUnit & Kotest

## 배포 프로세스 ##
![Deploy](https://github.com/user-attachments/assets/fe8b2fd3-abf7-4415-b61d-33ec9fdbab06)

## ERD ## 
![](https://github.com/user-attachments/assets/3a0d5c45-33f0-41f6-b7f8-9d2137aeaaae)

2.팀원 역할 및 서비스 구성 
===
## 팀원 역할 ## 

 [이아린](https://github.com/linavell)
- 가게
- 지역
- 카테고리 (연관관계)
- 가게 <-> 카테고리 연관관계 설정
  
[최용석](https://github.com/choi-ys)
- 주문
- 카트
- 결제
- 회원
  
[김용재](https://github.com/uzjaee)
- 메뉴 
- 메뉴 아이템 
- 메뉴 <-> 메뉴 아이템 연관관계 설정

## 서비스 구성 ## 

**domains**  : 어플리케이션 제작에 필요한 도메인 
- User  
- Auth 
- Region 
- Category 
- Shop 
- Menu 
- Order
- Payment

**global**  : 어플리케이션 제작에 필요한 설정
- config  
   - security 
   - jpa
- exception


3.Project 실행 및 테스트 
===
## docker를 이용한 local postgreSQL 구동 ## 
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
  
##  API  테스트 ## 

user > category ,region > shop  > ...   
해당 순서로 도메인 내  데이터가 존재해야 다른 API 테스트가 가능함 
1. user 생성
   
   [docs/client/auth-api.http](https://github.com/baedal-legend/foody/blob/develop/docs/client/auth-api.http)  
   a. 고객 회원 가입 API 실행  
   b. 회원 로그인 API 실행 

2. category ,region 생성  

   [docs/client/region-api.http](https://github.com/baedal-legend/foody/blob/develop/docs/client/category-api.http) 
  
    categorty를 생성하는 API 실행 > categoryId(UUID타입)반환  
   
   [docs/client/region-api.http](https://github.com/baedal-legend/foody/blob/develop/docs/client/region-api.http)  
  region 을 생성하는 api 실행 > regionId(UUID타입)반환 
  
3. shop 생성  
   
   [docs/client/shop-api.http](https://github.com/baedal-legend/foody/blob/develop/docs/client/shop-api.http)   
    Shop 생성 API 실행 (request body내 categoryIds 와 regionId 는 2번에서 반환 받은 Id 값 각각 사용)  

4. menu 생성  
   
   [docs/client/menu-api.http](https://github.com/baedal-legend/foody/blob/develop/docs/client/menu-api.http)  
    Menu 생성 API 실행 (request body 내 shopId는 3번에서 반환받은 shopId 값 사용 )

5. 나머지 API 테스트 
   
