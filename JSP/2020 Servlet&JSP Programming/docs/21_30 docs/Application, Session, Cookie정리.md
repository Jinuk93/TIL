# Application, Session, Cookie 정리

📌

### Application

Application 객체의 범위는 **“전역에서 상태값을 유지”** 할 수 있다

**application은 일반적으로 통용되는 전역개체 이름인 Application의 인스턴스이고, 그것이 서블릿에서는 ServletContext 객체로로 실현되어 있습니다**

→ **서블릿 컨텍스트(ServletContext) : 책갈피 역할, 기존의 내용을 이어서 읽을 수 있게한다** 

**A라는 서블릿**이 실행된 결과물을 저장하면

**B라는 서블릿**이 그 결과물을 이어서 새로운 결과물을 만들어낼 수 있도록 하는 상태저장공간이다

- **저장소 객체 생성**

**ServletContext application = request.getServletContext();** 

- **저장소에 값 저장*(값 저장만 set)***

**application.setAttribute("value", v)  // map 컬렉션(key, value)와 같이 저장한다.**

**application.setAttribute("op", op);**

- **저장소에 값 가져오기**

**application.getAttribute("value"); → 괄호 안에 저장한 키워드 값 넣기**

**Object 객체로 반환 됨(get 특성)으로 갖다줄 객체의 타입으로 형변환해야한다**

**int x = (Integer)application.getAttribute("value"); Wrapper 클래스를 활용해서 박싱**

---

### Session

<aside>
⭐ Application에서 application을 session으로 변경하면 사용방법은 같다

</aside>

Session 객체의 범위는 **“현재 접속한 사용자에 한해서 상태값을 유지”** 할 수 있다

- **저장소 객체 생성**

**HttpSession session = request.getSession();**

- **저장소에 값 저장*(값 저장만 set)***

**session.setAttribute("value", value);  //map 컬렉션(key, value)와 같이 저장한다.
session.setAttribute("op", op);**

- **저장소에 값 가져오기**

**String operator = (String)session.getAttribute("op");**

     

*부가설명*

**서로 다른 브라우저를 띄어서 동일한 사이트에 접속했을때 각각 다른 사용자로 생각하고 2개의 Session이 생성된다**

**반면에**

**하나의 브라우저를 2개 띄어서 동일한 사이트에 접속했을때는 같은 사용자로 생각하고 1개의 Session이 생성된다.**

**Application과 Session의 역할(기능)과 사용방법은 비슷하다.**

**둘 의 큰 차이점은 위의 설명처럼 “객체의 범위”이다.**

**Session은**

**사용자별로 공간이 달라질 수 있다 (각기 다른 웹브라우저는 session이 각각 생성된다)**

**(session마다, 현재접속자마다 공간이 달라진다)**

**같은 브라우저는** 

**여러 개를 띄워도 여러 개의 프로세스를 사용하는 개념이 아니라 스레드(Thread) 개념이기 때문**

**즉, 같은 session으로 인식된다.**

---

📌📌

**웹 서버는(Web Server) 어떻게 사용자의 세션을 식별하는가?** 

**결론은 Cookie**

브라우저를 통해 서버에 어떤 것을 요청할 때

해당 요청을 수행하다가 

프로그램에서 **다른 서블릿에게 전달하고** 싶은 내용이 있을 경우 저장하는 공간 **application**

**그 안에** **사용자마다 저장할 수 있는 공간**인 **session**이 있다.

**요청이 오면 서블릿이 실행되고** 

**이 사용자가 처음 방문한 경우에는 세션이 없다. (단, 어플리케이션은 사용할 수 있다)**

**이렇게 사용이 끝나면 브라우저는 해당 사용자에게 아이디(Session ID == SID)**

**를 부여해 주고 그에 따른 세션도 생긴다**

만약에, 브라우저가 달라졌다면 세션은 없는것이다(없어진 것이다?)

다시, ID를 생성하고 세션을 생성해야한다

**세션 아이디(SID)는 WAS(ex.톰캣)에 의해서 발급되는데, 브라우저를 닫게되면**

**세션은 사라지게된다. → 새롭게 발급받아야 한다** 

**다음에 그 브라우저가 방문했을 때 해당 아이디를 가지고 있기 때문에 그것을 통해 식별할 수 있게 된다 → Session의 기능인가? Session이 생겼기 때문에?**

Session의 비유

우리가 헬스장 혹은 학교를 가면

개인별로 사물함이 있다.

개인별 사물함에는 각각의 번호가 부여되는데, 각각의 공간이기 때문에 번호가 각각 있다.

---

**void setAttribute(String name, Object value); //지정된 이름으로 객체를 설정**

**Object getAttribute(String name); //지정한 이름의 객체를 반환**

**void invalidate(); //세션에서 사용되는 객체들을 바로 해제**

**void setMaxInactiveInterval(int interval); //세션 타임아웃을 정수(초)로 설정**

- --> 설정한 시간이전에 요청시 타임아웃을 초기화, 설정한 시간이 넘으면 새로운 Session ID로 인식한다.
- --> 세션을 무한정으로 유지시키면 저장소가 무한히 증가하게 됨으로 타임아웃을 세팅해줘서 세션 저장소를 관리한다.

- 메소드 Timeout : 30분

→ 타임아웃이 경과되고 SID를 요청하면 새로운 사용자로 인식한다

그리고 기존의 ID는 메모리에서 정리한다

→ session 생성시간, 요청시간등을 WAS에서 알 수 있고, Timeout 시간도 변경가능하다

---

### Cookie

**Session은 휘트니스 센터에 등록하여 사물함에 신발과 세면도구를 두고 다니는 경우고,**

**Cookie는 휘트니스 센터에 갈때마다 신발과 세면도구를 들고 다니는 경우로 생각하면 쉽다.**

**즉, 클라이언트가 상태값을 가지고 있다가 웹 서버에 보내고 다시 가져오는것!! (상태값은 유지된다.)**

📌

**Application 과 Session: 서버에 저장하는 저장소**

**Cookie: 클라이언트에 저장하는 저장소 *클라이언트는 ‘심는다’라는 비유가 적절한듯!**

---

📌

**클라이언트가 서버에 데이터를 요청할때, 크게 3가지의 값을 가지고 갈 수 있다.** 

1. **Header 정보**
2. (내가 보내는) **사용자 데이터**
3. **Cookie 의 데이터를 심을 수 있다.**

**웹 서버에서**

1. **Header 설정 데이터를 가져오려면 getHeader("remote-hose");**
2. **데이터를 가져오려면 getParameter("x");**
3. **Cookie를 가져오려면 getCookies();**

**로 데이터를 받을 수 있다.**

![Untitled](https://user-images.githubusercontent.com/80089860/158637706-51a6d0ef-3196-453a-9eb7-2a3be9d72fbc.png)

**addCookie() 메소드 :  쿠키를 사용자(브라우저)에게 보내지는 시작점이 되고(쿠키를 심는다)**

**getCookies() 메소드 : 그 사용자가 다시 방문했을 때 사용자가 가지고 있는 쿠키를 가지고 온다.**

****

- 쿠키즈는 배열이기 때문에 for문 안에서 키값을 찾고 그 키값에 따른 밸류 값을 찾아야 한다.

**즉, 서버(Server)가 브라우저(Client)에 저장할 때**

**addCookie를 보내면 클라이언트(Client)가 그 쿠키를 저장하고,**

**다음 요청에서 Cookie를 Server에서 꺼낸다(get)**

😬

***(클라이언트 -> 웹 서버) 웹 서버에 전달 된 쿠키 가져오기***

---

```java
// <쿠키 객체 2개생성>
			Cookie valueCookie = new Cookie("value", String.valueOf(value));
			Cookie opCookie = new Cookie("op", op);
// <쿠키를 Client에게 보낸다>
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
```

- **쿠키 객체 생성**

**Cookie[] cookies = request.getCookies(); //Client부터 전달 받은 쿠키를 저장하는 객체 생성**

**(쿠키는 여러개라고 가정해서 배열값이고, ies 복수형이다)**

**Cookie c = cookies[0] //0번째에 있는 cookies값을 쿠키객체 c에 저장**

**(웹 서버 -> 클라이언트)**

**1. 저장하고 클라이언트에게 보낼 쿠키 생성**

**형식: Cookie cookie = new Cookie("문자열", "문자열")**

**ex)**

**Cookie valueCookie = new Cookie("value", String.valueOf(v)); //쿠키 저장시 key와 value로 저장**

**Cookie opCookie = new Cookie("op", op);**

**2. 쿠키를 클라이언트에게 전달**

**response.addCookie(valueCookie);**

**response.addCookie(opCookie);**

---

### 32강 - Application/Session/Cookie의 차이점 정리

**Application 저장소**

**사용범위: 전역범위에서 사용하는 저장 공간**

**생명주기: WAS가 시작해서 종료할 때 까지**

**저장위치: WAS 서버의 메모리**

**Session 저장소**

**사용범위: 세션 범위에서 사용하는 저장 공간**

**생명주기: 세션이 시작해서 종료할 때 까지**

**저장위치: WAS 서버의 메모리**

**Cookie**

**사용범위: Web Browser별 지정한 path 범주 공간**

**생명주기: Browser에 전달한 시간부터 만료시간까지**

**저장위치: Web Browser의 메모리 또는 파일**

**기간을 오랫동안 가지고 사용해야한다면 Cookie에 저장하는게 합리적이다.**

**세션에 두고 사용하게 된다면 브라우저를 끄고 새로 열때마다 새로운 SID를 부여받고 세션 저장소에 저장하게 된다.**

**매번 새로운 SID값의 저장소를 만들게 되면 웹 서버 자원을 낭비하는 것이기 떄문에 Cookie를 사용**
