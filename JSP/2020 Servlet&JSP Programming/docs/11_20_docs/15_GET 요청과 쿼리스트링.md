# 15. GET 요청과 쿼리스트링

**‘사용자 요청’이라고 하면 가장 기본적인 것은 ‘GET요청’이다**

(**GET요청이란,** http://localhost/**hello** 에서 **hello** 라는 **servlet 문서를 요청**하는 것이다.)

![Untitled](15%20GET%20%E1%84%8B%E1%85%AD%E1%84%8E%20822f6/Untitled.png)

---

**문서를 요청(request)할 때는, 요구하는 옵션이 있을 수 있다.**

![Untitled](15%20GET%20%E1%84%8B%E1%85%AD%E1%84%8E%20822f6/Untitled%201.png)

예시. http://localhost/hello**?cnt=3** 

**(위처럼, 요구하는 옵션 "cnt=3"을 QueryString(쿼리스트링) 이라고 하고, “?”는 이를 구분하는 ‘구분자’이다.)**

![Untitled](15%20GET%20%E1%84%8B%E1%85%AD%E1%84%8E%20822f6/Untitled%202.png)

![Untitled](15%20GET%20%E1%84%8B%E1%85%AD%E1%84%8E%20822f6/Untitled%203.png)

📌

### GET방식 완벽정리!!

**GET방식(URL+Parameter)에서** 

**parameter 는 ?(구분자) 다음에 써져있는 ‘요청에서 요구되는 옵션’이다.**

**우리는 이 ‘옵션’부분(’ ?(구분자) 다음에 오는 ‘)을 쿼리스트링(QueryString)이라고 부른다**

 ****

**서버(Server)에서 클라이언트(Client)가 요청하는 옵션을 받으려면(읽으려면),**

**request.getParameter(”옵션명”); 을 통해 읽을 수 있다** 

**즉, getParameter를 통해 쿼리스트링(옵션)을 읽어낼 수 있다**

**위의 사진에 나와있는 코드를 예시로 들자면,**

**?cnt=3 에서 ’cnt=3’의  쿼리(스트링)를 읽을 수 있다.**