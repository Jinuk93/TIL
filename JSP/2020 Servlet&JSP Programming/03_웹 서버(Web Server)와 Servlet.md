# 03. 웹 서버(Web Server)와 Servlet

### Web

***Web(웹)이란 정적, 동적 컨텐츠를 모두 제공한다***

**Web과 Web ~~App~~ Server(WAS) 이렇게 보면 쉬울 듯 싶다**

**0. Web Server란?**

<aside>
⭐ html페이지 등을 네트워크망에 종속되지 않고, 웹서비스를 할 수 있도록 한다 (정적 )

</aside>

**예시.Apache, nginx**

### **1. WAS(Web ~~Application~~ Server)란?**

<aside>
⭐ 웹 서버(Web server) + 웹 컨테이너(예시. JSP, Servlet) (동적 )

</aside>

웹 서버가 요청을 받으면 애플리케이션에 대한 로직을 실행하여

웹 서버로 다시 반환해주는 소프트웨어입니다.

웹 서버와 DBMS 사이에서 동작하는 Middleware로서, Container 기반으로 동작합니다.

주로 DB Server와 같이 수행이 됩니다

- 기본 기능
1. ***프로그램 실행 환경과 데이터베이스 접속 기능을 제공한다.***
2. ***여러 개의 트랜잭션을 관리한다.***
3. ***업무를 처리하는 비즈니스 로직을 수행한다.***
4. ***Web Service 플랫폼으로서의 역할***

■ **웹 컨테이너 (Web Container)**

- **웹 컨테이너, 서블릿 컨테이너 : JSP와 서블릿을 실행시킬 수 있는 소프트웨어**
- **웹 서버(Web Server) → JSP 요청 → Tomcat에서 JSP를 Servlet으로 변환 → 컴파일 수행**

**→ 결과를 Web Server에 전달**

- **WAS는 JSP를 컴파일하여 ‘동적인 페이지’를 생성한다**
- **Container에는 Servlet, JSP, EJB 컨테이너 등이 있다**

### **2. WEB 서버와 WAS의 동작 과정**

![https://blog.kakaocdn.net/dn/GBzfo/btqCjdp7ZW0/VNlnK0l02YQVOUECg5zOt1/img.png](https://blog.kakaocdn.net/dn/GBzfo/btqCjdp7ZW0/VNlnK0l02YQVOUECg5zOt1/img.png)

### **3. WEB 서버와 WAS의 차이점**

언뜻보면 웹 서버와 WAS가 무슨 차이가 있지라는 생각을 하실 수 있습니다.

또한, 둘의 역할을 구분하시기 어려우실 수가 있습니다.

가장 큰 차이점은 **요청을 받아 처리하는 컨텐츠**에 있습니다.

**웹 서버의 경우 정적인 컨텐츠(HTML, CSS, IMAGE 등)를 요청받아 처리합니다.**

**WAS의 경우 동적인 컨텐츠(JSP, ASP, PHP 등)를 요청받아 처리합니다.**

### 4. WAS(Web Application Server)의 종류

**1-1 오픈소스**

Tomcat

Jetty

**2-1 상용소프트웨어**

WebLogic

JBoss

Jeus

---

### Servlet

<aside>
⭐ Server(서버) + let(조각)

</aside>

**서버의 한 조각(파편)으로서,**

**Client에서 Request한 부분에 대한 응답을 한다(응답한 뒤, 역할은 죽는다)**

**그러기에, 조각,파편이라는 뜻으로서, Server(서버)+let(조각) : ‘서버의 한 부분의 파편’**

**이라는 뜻으로서 이름이 유래가 된 것이라고 생각된다**

---

📌

### 정**리**

- **아파치 ( Web Server )**
    - **아파치는 ‘정적 컨텐츠(HTML, CSS, IMAGE)’를 처리하는 Web Server이다.**
    
- **톰캣 ( Tomcat )**
    - **아파치 재단에서 후원을 한다. 오픈소스로 개발되고 있으며, JSP와 Servlet을 구동하기 위한 ‘서블릿 컨테이너’ 역할을 수행한다. 위의 아파치(Web Server)와는 다르게 데이터베이스(DB)연결 및 ‘동적 컨텐츠’를 처리할 수 있다.**

- **컨테이너 ( Container )**
    - **위에서 자세하게 언급했지만, 간단하게 말하자면 ‘동적인 데이터’들을 ‘정적인 파일’로 만들어주는 모듈이다**

- **서블릿 ( Servlet )**
    - **Client의 요청을 받고 처리한다. 그 결과를, 자바 인터페이스 ( java, servlet, package )에 정의된 인터페이스로서 서블릿의 라이프 사이클을 위한 3가지 필수적은 메소드들을 정의한다**
        - **init()**
        - **service()**
        - **destroy()**

- **서블릿 컨테이너 ( Servlet Container )**
    - **서블릿들을 모아 관리한다. 새로운 요청이 들어올때마다, 새로운 스레를 생성작업이 끝난 서블릿 스레드를 자동으로 제거한다**

- **WAS(Web application Server)**
    - **프로그램 실행 환경과 데이터베이스 접속기능을 제공한다**
    - **여러개의 트랜잭션 관리**
    - **업무를 처리하는 비즈니스 로직 수행**
