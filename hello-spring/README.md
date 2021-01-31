# inflearn 스프링 입문/ 스프링 핵심원리로 학습한 내용

## 2021/01/31
&#35; JAVA 11
&#35; IDE : IntelliJ

* https://start.spring.io 로 프로젝트 생성 
* 스프링부트에 톰캣서버가 내장되어있기때문에 따로 설정은 해 주지않았다
  - 8080포트를 이미 사용중이어서 application.properties에 따로 설정을 해 주었다
  ```
  server.port = 8081
  ```
* gradle로 라이브러리를 관리 할 경우 필요한 라이브러리에 의존성 있는 라이브러리를 함께 다운로드한다
  - spring-boot-starter-web
    + spring-boot-starter-tomcat 톰캣(웹서버)
    + spring-webmvc : 스프링 웹 MVC
  - spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
  - Spring-boot-starter(공통) : 스프링 부트 + 스프링코어 + 로깅
    + spring-boot
      + spring-core
    + spring-boot-starter-logging
      + logback, slf4j
    
  - 테스트 라이브러리
    + junit : 테스트 프레임워크
    + mockito : 목 라이브러리
    + assertj : 테스트코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    + spring-test : 스프링 통합 테스트 지원
* 웰컴페이지 = resources/static/index.html 
* Controller에는 @Controller 어노테이션을 붙여준다
* Controller 메소드에는 @GetMapping 어노테이션을 붙여준다
* Model 객체에 data를 담아서 이동시킨다
* controller에서 리턴값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아 처리한다
  - 스프링 구동순서 다시 복습해야겠다...
* build
  - 서버구동을 끄고 cmd창에서 프로젝트 디렉토리까지 들어간다
  - 나는 윈도우기때문에 gradlew.bat 실행 ( gradlew.bat build / gradlew.bat clean build)
  - 에러발생 :  Could not target platform: 'Java SE 11' using tool chain: 'JDK 8 (1.8)'
  - 인텔리제이에서는 다 변경해줬는데 또 에러가 나는 것으로 보아 환경변수쪽 문제 같아서 수정 후 재부팅 -> 빌드완료
  - build > libs 로 들어가서 hello-spring-0.0.1-SNAPSHOT.jar 생성된 것을 확인한 후 실행
  - java -jar hello-spring-0.0.1-SNAPSHOT.jar
  
  
  
  
  
  
