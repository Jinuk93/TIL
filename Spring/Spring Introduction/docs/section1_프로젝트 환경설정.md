# section1 프로젝트 환경설정

- 목차

---

## 프로젝트 생성

### 1. 설치

![Untitled](https://user-images.githubusercontent.com/80089860/163218020-23b1dc85-549a-4925-8335-3af5167d4252.png)


### 2. Spring Framework 훑어보기

![Untitled 1](https://user-images.githubusercontent.com/80089860/163218069-8eec6016-ab61-4d10-b4e6-3d6f12ef902c.png)

![Untitled 2](https://user-images.githubusercontent.com/80089860/163218074-8c40d0e0-b909-447d-bdd0-57a644856461.png)

![Untitled 3](https://user-images.githubusercontent.com/80089860/163218083-8255422c-0bef-4233-9c95-16015fedb8c7.png)

### Gradle JDK 설정

- Windows: File -> Settings(Ctrl+Alt+S)
- Mac: IntelliJ IDEA | Preferences(⌘,)

![Untitled 4](https://user-images.githubusercontent.com/80089860/163218100-94721a83-1525-4308-b5fa-1eab14d18267.png)

---

## 라이브러리 살펴보기

### 땡겨온 라이브러리 보는법

![Untitled 5](https://user-images.githubusercontent.com/80089860/163218116-f8eeb60a-ac7d-4e29-b658-09b793d36078.png)

![Untitled 6](https://user-images.githubusercontent.com/80089860/163218127-5a859526-e7a0-4235-aa60-a052edf0f43f.png)

### Gradle이나 Maven 같은 tool들은 의존 관계를 정리해준다

- 무슨뜻이야?
    - 예를 들자면, spring-boot-starter-web 이라는 라이브러리를 사용하려고 한다. 그러면, 이 라이브러리에서 필요한것들이 있는데, 그 라이브러리들을 모두 땡겨와준다(가져와준다)
    - **라이브러리가 라이브러리를 가져온다고? → 맞다. 그것을 ‘의존 관계’ 라고 부른다.**
    - 쉽게 비유하자면, **A라는 라이브러리가 B라는 라이브러리들을 가져와준다**
    - **Gradle이나 Maven 같은 tool들이 의존관계를 정리해준다’라는 말을 좀 더 쉽게 말해보자면, A라는 라이브러리를 가져왔을 때, B라는 라이브러리를 내가 ‘굳이’,’따로’ 안가져와도 되게끔 히는 역할을 한다.**
    

**아래 사진을 참조해보자. 라이브러리가 다른 라이브러리를 땡겨왔다는것을 볼 수 있다(의존관계)**

![Untitled 7](https://user-images.githubusercontent.com/80089860/163218147-782ddfb9-ecbd-4e47-9098-87ab93f6449b.png)

![https://blog.kakaocdn.net/dn/bbLxr3/btruXYMak6R/7MtOEQdfzCh1EE8grcALnK/img.png](https://blog.kakaocdn.net/dn/bbLxr3/btruXYMak6R/7MtOEQdfzCh1EE8grcALnK/img.png)

첫 번쨰 사진처럼, 우리는 처음 spring.io에서 thymeleaf와 web이라는 두 개의 라이브러리들을 필요로 했는데,

그 두개의 라이브러리가 필요로 하는 더 많은 라이브러리들이 토글로 나열되있는것을 볼 수 있다.

위의 사진을 보면, 나열된 라이브러리 우측 끝에 (*)가 붙어져있는 것을 볼 수 있는데, 이것은 다른 곳에서 이미 설치가 되어있어 중복되었다는 것을 말한다.

### 로깅(**logging) 관련 라이브러리**

![https://blog.kakaocdn.net/dn/cx4cJI/btru0vbXffj/aeQ8eNj58Af1jrfE8JGsok/img.png](https://blog.kakaocdn.net/dn/cx4cJI/btru0vbXffj/aeQ8eNj58Af1jrfE8JGsok/img.png)

*logback 과 slf4j가 있는데 slf4j는 쉽게 말해서 인터페이스이고 실제 로그를 어떤 구현체로 출력할건지에 대해 logback을 많이 선택한다 
(성능도 빠르고, 지원하는 기능도 좋다. 위의 두 가지 조합을 많이 쓴다)*

### 테스트 관련 라이브러리

- 자바 진영에서 테스트를 할 때 junit이라는 것을 많이 사용한다.

![Untitled 8](https://user-images.githubusercontent.com/80089860/163218176-35ba339a-f371-49d4-ae56-182295d0b291.png)

- spring-test : spring과 통합해서 테스트할 수 있도록 도와주는 라이브러리

![Untitled 9](https://user-images.githubusercontent.com/80089860/163218194-4939f0bd-8206-4a57-94c1-4274d2b02f05.png)

### <라이브러리 살펴보기> 정리

![Untitled 10](https://user-images.githubusercontent.com/80089860/163218210-8d8ce92a-4941-43fe-94e9-959990f07557.png)

---

## View 환경설정

### 시작페이지 만들기

1. **static 폴더에서 New File → index.html을 만든다**

![Untitled 11](https://user-images.githubusercontent.com/80089860/163218224-2ff3bd64-bd4e-424f-b91b-82bcb005bd38.png)

```html
<!DOCTYPE HTML>
<html>
<head>
 <title>Hello</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```

### *결과*

![Untitled 12](https://user-images.githubusercontent.com/80089860/163218246-ac438ba9-b56e-4add-849c-b582f1bda05e.png)

### *이거에 관련된 주절주절*

### 스프링부트는 기능이 방대해서, 필요한 정보를 찾을 줄 아는 것이 중요하다.

- welcome page를 만들고자 할 때, 관련된 정보를 어떻게 찾지?
    
    ![Untitled 13](https://user-images.githubusercontent.com/80089860/163218269-1f796810-fee9-4f23-be85-1c76a5333d48.png)
    

### 결국, 메뉴얼에서 검색을 할 줄 알아야 한다

**위에서 hello hello라는 시작페이지를 만들었다. 
이것은 입력한 것을 그대로 출력하는 ‘정적 페이지’이다
이제 ‘템플릿 엔진’이라는 것을 사용해서, html의 모양을 원하는 형태로 바꿀 수 있다.**

### 주절주절 끝.

1. **Controller를 만들 것이다.**

![Untitled 14](https://user-images.githubusercontent.com/80089860/163218304-07c746a2-d445-41bb-b8d7-57ab8644361a.png)

![Untitled 15](https://user-images.githubusercontent.com/80089860/163218331-003b4bfd-f957-4868-b417-d271d62e0909.png)

아래의 사진들을 보자

**위의 컨트롤러에서 attributeValue에 저장되있던 hello가 html에서 ${data}가 있는 위치로 치환된다**

**그 이유는 위의 컨트롤러 사진에서 attributeName을 “data”로 지정해두었기 때문이다.**

![Untitled 16](https://user-images.githubusercontent.com/80089860/163218383-aad304e1-0dd5-4f50-9c86-b83eae0b8f37.png)

![Untitled 17](https://user-images.githubusercontent.com/80089860/163218407-9cb0f992-0277-4032-a3b0-e04661191ff7.png)

위의 코드에 대한 동작하는 구조를 그림으로 살펴보자

![https://blog.kakaocdn.net/dn/ccBsu3/btru5qubqI3/dhUdXogImW1CAJ3WKG5C61/img.png](https://blog.kakaocdn.net/dn/ccBsu3/btru5qubqI3/dhUdXogImW1CAJ3WKG5C61/img.png)

### 📌이 위에 대한 그림구조는 Servlet/JSP에서 공부했던 MVC model를 이해하면 이해하기 쉽다

![Untitled 18](https://user-images.githubusercontent.com/80089860/163218435-678dc853-7042-4715-858d-5258a1798c0c.png)

→

![Untitled 19](https://user-images.githubusercontent.com/80089860/163218460-b49b0d11-ced5-4fb3-a16f-a8f325e88d06.png)

📌**중요**

- 사용자가(User)가 ‘커피’라던지 어떠한 데이터를 JSP단에서 클릭을 통해서 요청한다
- 요청은 컨트롤러를 통해서 모델(데이터)한테 전달된다 → 사용자가 요구한 데이터 내놓아라!
- 우리는 모델로부터 받아온 데이터를 return을 통해 Mapping된 JSP 즉, View단으로 데이터를 뿌려주게 된다

위의 코드로 해석해본다면

- modelAttribute를 통해 사용자가 요구한 데이터를 설정한다( 무슨데이터를 원하는지 등 )
- return을 통해 처음에 불렀던 놈(Mapping된 친구)에게로 데이터를 준다 → html이 불렀다
- html에서 ${data}를 통해 가지고 왔던 데이터를 뿌려준다

---

### 빌드하고 실행하기

- 윈도우 기준의 설명
    - 우선, 톰캣포트 8080이 실행되기 때문에, 스프링을 중단하고 실행한다
1. cmd 창을 연다
2. cd 명령어를 통해 스프링 프로젝트로 이동
3. dir를 입력해서 우선 gradlew.bat가 있는지 확인 후, 있으면 제대로 이동한 것이다
4. 그리고 이제 gradlew 엔터
5. gradlew build 엔터
6. cd build/libs
7. java -jar hello-spring-0.0.1-SNAPSHOT.jar 을 입력하면 실행된다

이제 서버에 배포할 때는 hello-spring-0.0.1-SNAPSHOT.jar 이 파일만 복사해서 서버에 넣어주고, 실행을 시켜주면 된다.

만약 잘 안된다면, gradlew clean build를 사용해서 build 폴더를 완전히 삭제 후, 다시 시도해보면 좋을 것 같다.

### 성공화면(?)

![Untitled 20](https://user-images.githubusercontent.com/80089860/163218480-33c1ee0e-59dd-441e-9972-90c2b235cb26.png)
