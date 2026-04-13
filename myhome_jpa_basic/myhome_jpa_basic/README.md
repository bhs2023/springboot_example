# MyHome JPA Basic - 게시판 프로젝트

Spring Boot + JPA + MySQL을 사용한 기본 게시판 프로젝트입니다.

## 기술 스택

- **Spring Boot** 3.2.1
- **Spring Data JPA**
- **MySQL** 8.0+
- **HikariCP** (Connection Pool)
- **Lombok**
- **Maven**

## 프로젝트 구조

```
myhome_jpa_basic/
├── src/
│   ├── main/
│   │   ├── java/com/example/myhome/
│   │   │   ├── entity/
│   │   │   │   └── Board.java
│   │   │   ├── repository/
│   │   │   │   └── BoardRepository.java
│   │   │   ├── service/
│   │   │   │   └── BoardService.java
│   │   │   ├── controller/
│   │   │   │   └── BoardController.java
│   │   │   └── MyhomeJpaBasicApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/
├── pom.xml
└── README.md
```

## 데이터베이스 설정

### 1. MySQL 데이터베이스 생성

```sql
CREATE DATABASE myhome_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. application.properties 설정

MySQL 접속 정보를 본인의 환경에 맞게 수정하세요:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/myhome_db
spring.datasource.username=root
spring.datasource.password=root
```

## Board 엔티티 필드

| 필드명 | 타입 | 설명 |
|--------|------|------|
| seq | Long | 게시글 번호 (PK, Auto Increment) |
| title | String | 제목 |
| writer | String | 작성자 |
| wdate | LocalDateTime | 작성일시 |
| contents | String | 내용 |
| hit | Integer | 조회수 |

## 실행 방법

### 1. Maven 빌드

```bash
mvn clean install
```

### 2. 애플리케이션 실행

```bash
mvn spring-boot:run
```

또는

```bash
java -jar target/myhome_jpa_basic-1.0.0.jar
```

### 3. 실행 확인

- 서버 주소: http://localhost:8080
- 초기 데이터 20개가 자동으로 등록됩니다

## API 엔드포인트

### 게시글 목록 조회
```
GET /api/boards
```

### 게시글 상세 조회 (조회수 증가)
```
GET /api/boards/{seq}
```

### 게시글 등록
```
POST /api/boards
Content-Type: application/json

{
    "title": "게시글 제목",
    "writer": "작성자",
    "contents": "게시글 내용"
}
```

### 게시글 수정
```
PUT /api/boards/{seq}
Content-Type: application/json

{
    "title": "수정된 제목",
    "writer": "수정된 작성자",
    "contents": "수정된 내용"
}
```

### 게시글 삭제
```
DELETE /api/boards/{seq}
```

### 제목으로 검색
```
GET /api/boards/search/title?keyword=검색어
```

### 작성자로 검색
```
GET /api/boards/search/writer?writer=작성자명
```

### 인기 게시글 조회 (조회수 상위 10개)
```
GET /api/boards/popular
```

## API 테스트 예제 (cURL)

### 전체 게시글 조회
```bash
curl -X GET http://localhost:8080/api/boards
```

### 특정 게시글 조회
```bash
curl -X GET http://localhost:8080/api/boards/1
```

### 게시글 등록
```bash
curl -X POST http://localhost:8080/api/boards \
  -H "Content-Type: application/json" \
  -d '{
    "title": "새로운 게시글",
    "writer": "홍길동",
    "contents": "테스트 내용입니다."
  }'
```

### 게시글 수정
```bash
curl -X PUT http://localhost:8080/api/boards/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "수정된 제목",
    "writer": "홍길동",
    "contents": "수정된 내용입니다."
  }'
```

### 게시글 삭제
```bash
curl -X DELETE http://localhost:8080/api/boards/1
```

## 주요 기능

- ✅ 게시글 CRUD (등록, 조회, 수정, 삭제)
- ✅ 게시글 상세 조회 시 조회수 자동 증가
- ✅ 제목/작성자 검색 기능
- ✅ 인기 게시글 조회 (조회수 기준 상위 10개)
- ✅ HikariCP를 이용한 Connection Pool 관리
- ✅ data.sql을 통한 초기 데이터 20개 자동 생성

## HikariCP 설정

```properties
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.max-lifetime=1800000
```

## 주의사항

1. MySQL 서버가 실행 중이어야 합니다
2. `myhome_db` 데이터베이스가 생성되어 있어야 합니다
3. application.properties의 DB 접속 정보를 확인하세요
4. Java 17 이상 버전이 필요합니다

## 라이센스

MIT License
