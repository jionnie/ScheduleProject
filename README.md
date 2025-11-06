# 📆 일정 관리 CRUD 프로젝트

## ✅ 프로젝트 소개

일정 관리 CRUD 프로젝트 <br>
개발 기간: 2025.11.03~2025.11.06

## ✅ 개발 환경

- **OS**: Windows 11
- **IDE**: IntelliJ IDEA
- **Language**: Java 17
- **Build Tool**: Gradle
- **Version Control**: Git, GitHub
- **Test Tool**: Postman

## ✅ 기술 스택

- **Language**: Java
- **Framework**: Spring Boot
- **ORM**: JPA (Hibernate)
- **Database**: MySQL

## ✅ 실행 방법

- 사전 준비: application.properties에서 데이터베이스 연결 정보 확인
  
```
spring.datasource.url=jdbc:mysql://localhost:3306/schedule_db
spring.datasource.username=root
spring.datasource.password=비밀번호
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

- 방법 1
  - 명령 프롬프트 또는 터미널 열기
  - 프로젝트 경로로 이동
  - ```./gradlew clean build ```로 프로젝트 빌드
  - ```java -jar build/libs/schedule-0.0.1-SNAPSHOT.jar```

- 방법 2
  - 인텔리제이에서 ```ScheduleApplication``` 실행

## ✅ 주요 기능

- 일정 등록
- 일정 조회
  - 단 건 조회, 작성자 별 조회, 전체 조회
  - 해당 일정에 달린 댓글 조회
- 일정 수정
  - 비밀번호 일치 시 수정
- 일정 삭제
  - 비밀번호 일치 시 삭제 
- 댓글 등록

## ✅ 패키지 구조

```
com.example.schedule
             ├── controller
                    ├── CommentController
                    └── ScheduleController
             ├── dto
                    ├── CreateCommentRequest
                    ├── CreateCommentResponse
                    ├── CreateScheduleRequest
                    ├── CreateScheduleResponse
                    ├── DeleteScheduleRequest
                    ├── GetCommentResponse
                    ├── GetScheduleResponse
                    ├── UpdateScheduleRequest
                    └── UpdateScheduleResponse
             ├── entity
                    ├── BaseEntity
                    ├── Comment
                    └── Schedule
             ├── exception
                    ├── CommentLimitExceededException
                    ├── GlobalExceptionHandler
                    └── InvalidPasswordException
             ├── repository
                    ├── CommentRepository
                    └── ScheduleRepository
             ├── service
                    ├── CommentService
                    └── ScheduleService
             └── ScheduleApplication
```

## ✅ API 명세서

[https://documenter.getpostman.com/view/48484019/2sB3WpSMJL](https://documenter.getpostman.com/view/48484019/2sB3WpSMJL)

## ✅ ERD 다이어그램

<img width="947" height="404" alt="image" src="https://github.com/user-attachments/assets/ddb3ce24-0024-4bae-903b-587c61969c54" />

application.properties 복사본 첨부하기
