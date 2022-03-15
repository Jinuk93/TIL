# 20. 서블릿 필터(Servlet Filter)

---

- **서블릿 컨테이너(Servlet Container) : 서블릿(Servlet)이 실행되면, 메모리상에 존재하는 데**

**그 공간을 ‘서블릿 컨테이너(Servlet Container)’라고 부른다**

**WAS (우리는 톰캣사용) 은 그 Servlet을 Container에 넣어놓고**

**결과를 돌려준다. 그리고, 서블릿(Servlet)의 사용이 끝나면, 컨테이너(Container)에서 삭제한다**

---

클라이언트(Clinet)로 부터 입력받은 한글 데이터를 처리하는 서블릿(Servlet) 마다 request.setCharacterEncoding("UTF-8");를 써줘야하는 상황이 발생하는데,

- 해결방법 : 서블릿이 실행하기 **전,후 로 실행되는 서블릿 필터**를 만들어준다.

**필터 실행은 톰캣이 처음 실행할때 필터가 실행되며, 요청이 올때마다 전,후로 실행된다.**

---

![Untitled](https://user-images.githubusercontent.com/80089860/158417420-d3b36738-c89b-47bb-ae00-d16430f6f552.png)

[서블릿 필터란?](https://www.notion.so/1b2ae2fa35c04c9397e7816752d3720e)

**서블릿 필터(Servlet Filter)란?**

**Client로 부터 Server로 요청이 들어오기 전에 서블릿을 거쳐서 필터링 하는 것을** 

**서블릿 필터**라고 한다.

Servlet과 거의 동일하지만 기능이 Filtering 이기 때문에 이렇게 이름이 지어졌다고 한다.

지금까지 **Servlet은 HTTPServletRequest였다면 Filter는 ServletRequest이다.**

**Filter의 ServletRequest가 더 부모클래스이다.**

### 서블릿 필터 설정 (클래스 생성 -> 인터페이스 Add -> Filter 검색 -> servlet Filter 추가)

![https://blog.kakaocdn.net/dn/bAHbuj/btqSDu20xSN/eLP4FEXCDWgHrCxr4cduZk/img.png](https://blog.kakaocdn.net/dn/bAHbuj/btqSDu20xSN/eLP4FEXCDWgHrCxr4cduZk/img.png)

### 방법 1 : web.xml에 등록

![Untitled 1](https://user-images.githubusercontent.com/80089860/158417436-d4daffdb-a123-4abc-836a-661018dfa982.png)

### 방법 2 : 어노테이션(Annotation)

1. 필터-클래스(Filter-class) 위에 해당 어노테이션(Annotation) 작성한다
2. @WebFilter("**/***")     //필터를 적용할 url을 괄호 안에 작성 해준다.

---

Filter 인터페이스 작성

System.out.println("before filter"); ------ 1

chain.doFilter(request, response); ------ 2

System.out.println("after filter"); ----- 3

순서 (1)

before filter 출력

순서 (2)

chain.doFilter(request, response);

역할: 요청이 오면 다음 Filter 또는 해당 Servlet으로 넘어가게 결정 할 수 있는 역할을 한다.

관문소 및 이정표 역할

순서 (3) 

반환후 after filter 가 출력된다.

따라서 한글 데이터 값을 웹서버로 전송했을때 깨지는 현상을 filtering 해주려면

request.setCharacterEncoding("UTF-8"); 

//요청 받은 값을 UTF-8 로 읽어들인다고 웹서버에 설정한 뒤

chain.doFilter(request, response); 

//검문소를 통과후 Servlet으로 진행하게 한다.

---

### 자세한 설명참조 사이트 : [https://blog.naver.com/ttb190926/222395275479](https://blog.naver.com/ttb190926/222395275479)
