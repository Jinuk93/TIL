# 03 View환경설정

### Welcome Page 만들기

resources/static/index.html

***→ 정적인 페이지를 생성할 것이다. static***

```java
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

우리가 도메인 주소를 통해 들어왔을 때, 제일 먼저 마주하는 페이지를

Welcome-Page라고 표현한다

![Untitled](https://user-images.githubusercontent.com/80089860/160245027-bc040899-58e8-4f36-a203-ddb36237614d.png)

![Untitled 1](https://user-images.githubusercontent.com/80089860/160245029-ce54816c-55bf-419e-84ae-c0a1bdfd3cf8.png)

![Untitled 2](https://user-images.githubusercontent.com/80089860/160245030-a83efed3-0c9e-4351-85de-a9ab0245b78c.png)

*File을 눌러서 생성한다*

*파일명을 ‘index.html’로 생성한다*

*그리고, 위의 적힌 코드들을 복사 붙여넣기로 작성한다*

*그리고 서버를 켜서 실행한다*

### 실행결과

![Untitled 3](https://user-images.githubusercontent.com/80089860/160245040-c3cea31b-7800-4978-b306-16962e980220.png)

---

### 스프링 부트가 제공하는 Welcome Page 기능

- static/index.html 을 올려두면 Welcome page 기능을 제공한다.
    
    [Spring Boot Features](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page)
    

### thymeleaf 템플릿 엔진

***→ ‘템플릿 엔진’을 쓰면, 위에서 정적인 페이지를 만들었을 때처럼, html 페이지를 모양을 편리하게 바꿀 수 있다 이것을 ‘템플릿 엔진’이라고 부른다. 우리는 ‘타임리프’라는 템플릿 엔진을 쓸 것이다***

- thymeleaf 공식 사이트: [https://www.thymeleaf.org/](https://www.thymeleaf.org/)
- 스프링 공식 튜토리얼: [https://spring.io/guides/gs/serving-web-content/](https://spring.io/guides/gs/serving-web-content/)
- 스프링부트 메뉴얼: [https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/)
html/spring-boot-features.html#boot-features-spring-mvc-template-engines

![Untitled 4](https://user-images.githubusercontent.com/80089860/160245061-2071db83-79ad-4480-80fb-e905d24c6d3a.png)

*아래는 컨트롤러 코드*

```java
@Controller
public class HelloController {
 @GetMapping("hello")
 public String hello(Model model) {
 model.addAttribute("data", "hello!!");
 return "hello";
 }
}
```

```java
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
 <title>Hello</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```

**resources/templates/hello.html**

### thymeleaf 템플릿엔진 동작 확인

- **실행: [http://localhost:8080/hello](http://localhost:8080/hello)**

## Controller : 웹 앱에서 제일 첫번째의 진입점이 ‘컨트롤러’

---

![Untitled 5](https://user-images.githubusercontent.com/80089860/160245073-ec966e90-ee65-4bb7-a50a-6cc77d0359b1.png)

![Untitled 6](https://user-images.githubusercontent.com/80089860/160245075-579bf86c-6c7b-487e-a3ee-fb7abbeccf38.png)

![Untitled 7](https://user-images.githubusercontent.com/80089860/160245077-d352d268-7a6a-4ba4-b4bb-5d783991133d.png)

1. 먼저 패키지를 새로 생성한다

![Untitled 8](https://user-images.githubusercontent.com/80089860/160245079-40301041-b64d-41f2-b596-352b07060bc0.png)

1. HelloController 라는 클래스를 만든다

![Untitled 9](https://user-images.githubusercontent.com/80089860/160245085-bebb2f18-b089-4d70-90a1-dc715d3ab8e0.png)

1. 위처럼 컨트롤러의 코드를 작성한다

![Untitled 10](https://user-images.githubusercontent.com/80089860/160245089-5295e6c4-ea87-496e-a2b2-2a30d1789b1b.png)

1. 템플릿에서 file 만들기를 누르고 hello.html을 생성한다

![Untitled 11](https://user-images.githubusercontent.com/80089860/160245099-708ef7f5-6ac6-4786-8055-c13bd1233a22.png)

1. 위에 있는 html 코드를 복사 붙여넣기 한다
- 사진에서 상단을 보면 알겠지만, ‘타임리프’의 템플릿 엔진이 선언되있는것을 알 수 있다.

![Untitled 12](https://user-images.githubusercontent.com/80089860/160245105-21fdb4dd-c3f6-470c-a1e6-3b612125a68d.png)

위 컨트롤러에서의 data와

아래 htm에서의 data가 같다

![Untitled 13](https://user-images.githubusercontent.com/80089860/160245109-1a333e55-d5b3-4dcb-b2cd-1dae5814424c.png)

그리고, html에서 data는 컨트롤러에서 data의 value값인 hello로 값을 가져올것이다.

![Untitled 14](https://user-images.githubusercontent.com/80089860/160245118-a85fae24-49fe-4ef9-943f-f2d661e1fb07.png)

### 실행결과

![Untitled 15](https://user-images.githubusercontent.com/80089860/160245127-9c3769d1-3f50-4058-9279-014e2e613938.png)

![Untitled 16](https://user-images.githubusercontent.com/80089860/160245130-991005f3-40b9-4fa3-aee4-8418b7c538f5.png)

```java

<!-- HelloController.java -->
// 이친구는 컨트롤러 느낌(?), 자바코드
package SpringIntroduction.Hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
```

```java
<!-- hello.html -->
// 이친구는 뷰(View) 느낌(?), html코드
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```

---

### 동작환경그림

- **컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.**
    - **스프링 부트 템플릿엔진 기본 viewName 매핑**
    - **resources:templates/ +{ViewName}+ .html**
    
---

참고: 

***spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다.***

> **인텔리J 컴파일 방법: 메뉴 build Recompile**
>
