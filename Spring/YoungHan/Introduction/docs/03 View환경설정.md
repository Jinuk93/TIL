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

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled.png)

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%201.png)

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%202.png)

*File을 눌러서 생성한다*

*파일명을 ‘index.html’로 생성한다*

*그리고, 위의 적힌 코드들을 복사 붙여넣기로 작성한다*

*그리고 서버를 켜서 실행한다*

### 실행결과

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%203.png)

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

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%204.png)

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

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%205.png)

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%206.png)

1. 먼저 패키지를 새로 생성한다

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%207.png)

1. HelloController 라는 클래스를 만든다

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%208.png)

1. 위처럼 컨트롤러의 코드를 작성한다

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%209.png)

1. 템플릿에서 file 만들기를 누르고 hello.html을 생성한다

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2010.png)

1. 위에 있는 html 코드를 복사 붙여넣기 한다
- 사진에서 상단을 보면 알겠지만, ‘타임리프’의 템플릿 엔진이 선언되있는것을 알 수 있다.

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2011.png)

위 컨트롤러에서의 data와

아래 htm에서의 data가 같다

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2012.png)

그리고, html에서 data는 컨트롤러에서 data의 value값인 hello로 값을 가져올것이다.

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2013.png)

### 실행결과

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2014.png)

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2015.png)

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

![Untitled](03%20View%E1%84%92%E1%85%AA%E1%86%AB%20b92d6/Untitled%2016.png)

- **컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.**
    - **스프링 부트 템플릿엔진 기본 viewName 매핑**
    - **resources:templates/ +{ViewName}+ .html**
    

---

참고: 

***spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다.***

> **인텔리J 컴파일 방법: 메뉴 build Recompile**
>