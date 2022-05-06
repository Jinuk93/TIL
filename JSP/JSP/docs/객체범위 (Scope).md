Scope(스코프)는 ‘범위’,’변수 영역’라는 뜻이다

**객체 범위 종류**

웹 애플리케이션에는 4개의 객체 범위가 존재합니다.

1. **page 영역**
    - 한 번의 클라이언트 요청이 오면, 하나의 JSP 페이지가 응답됩니다.
    - **page 영역은 이 때 하나의 JSP 페이지 내에서만 객체를 공유하는 영역을 의미합니다. ( JSP only )**
        - **JSP 파일에는 pageContext가 내장되어 있으며, 이 객체는 page 영역에서만 유효합니다.**
        - **JSP 파일에 <% %> 안에 변수를 사용하면 이 변수는 해당 JSP 파일 내에서만 유효한데, page 스코프에 정의된 객체이기 때문입니다.**
        
2. **request 영역**
    - 요청을 받아서 응답하기까지 객체가 유효한 영역입니다.
    - Servlet에서 **forward 또는 include를 사용하면, request 요청 객체가 공유되어서 request 영역이 됩니다.**
    - 지금까지 Servlet에서 JSP로 객체를 보낼 때 사용했던 방법입니다.
        - Servlet에서는 reqeust.setAttribute("이름", 객체); 로 전달하였고,
        - JSP에서는 Obejct ob j = request.getAttribute("이름"); 으로 받았습니다.
        - 이 때 사용했던 request 객체가 request 영역입니다.
        
3. **session 영역**
    - 하나의 브라우저 당 1개의 session 객체가 생성됩니다.
    - 즉, **같은 브라우저 내에서 요청되는 페이지들은 같은 객체를 공유**하게 되는데, 이를 세션 영역이라고 합니다.
    - 세션이 종료되면 객체는 반환됩니다.
    - requset.getSession() 메서드를 호출하여 세션 영역의 객체를 얻을 수 있습니다.
    
4. **application 영역**
    - 하나의 애플리케이션 당 1개의 application 객체가 생성됩니다.
    - 즉, **같은 애플리케이션 내에서 요청되는 페이지들은 같은 객체를 공유**하게 되는데 이를 애플리케이션 영역이라고 합니다.
    - 애플리케이션이 종료되면 객체는 반환됩니다.
    - request.getServletContext() 메서드를 호출하여, 애플리케이션 영역의 객체를 얻을 수 있습니다.
    

이로 미루어 보아 scope 범위는 **page < request < session < application** 순이라는 것을 알 수 있습니다.

[https://t1.daumcdn.net/cfile/tistory/99D9A73D5AAE58C40B](https://t1.daumcdn.net/cfile/tistory/99D9A73D5AAE58C40B)

**2. 테스트**

4개의 scope 개념에 대해 알았으니, 이제 어떻게 활용하는지 알아보도록 하겠습니다.

ScopeServlet.java

```
@WebServlet("/scope")
public classScopeSerlvetextendsHttpServlet {
private static final longserialVersionUID= 1L;

protected voiddoGet(HttpServletRequest request, HttpServletResponse response)throwsServletException, IOException {
// page는 JSP파일에서 작성 ( JSP only )

        // request
request.setAttribute("num2", 20);

// session
request.getSession().setAttribute("num3", 30);

// application
request.getServletContext().setAttribute("num4", 40);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        rd.forward(request, response);
    }

protected voiddoPost(HttpServletRequest request, HttpServletResponse response)throwsServletException, IOException {
        doGet(request, response);
    }
}
```

각 영역에 객체를 할당하는 방법은 위와 같습니다.

page 영역은 JSP 내에서만 존재하므로 Servlet에서 만들 수 없습니다.

이제 JSP 파일을 만들어서 각 영역의 값을 확인해보겠습니다.

/WEB-INF/index.jsp

```
<%
    pageContext.setAttribute("num1", 10);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <metahttp-equiv="Content-Type"content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    ${ pageScope.num1 } <br>
    ${ requestScope.num2 } <br>
    ${ sessionScope.num3 } <br>
    ${ applicationScope.num4 } <br>
    <hr>
    ${ num1 } <br>
    ${ num2 } <br>
    ${ num3 } <br>
    ${ num4 } <br>
</body>
</html>
```

Scope를 출력하는 방법은 위와 같습니다.

- 지금까지 java 코드 값을 출력하는 방식으로 <%= %>을 사용했었는데, 지금은 ${ }을 사용했습니다.
- ${ }은 표현식으로서, 에서 자세히 다룹니다. 지금은 각 Scope의 값을 출력하는 방법에 주목해주세요.
    
    **[다음 글](https://victorydntmd.tistory.com/156)**
    

첫 번째 방법은 Scope 영역을 명시하고 출력하고자 하는 애트리뷰트 명을 작성했고,

두 번째 방법은 바로 애트리뷰트 명을 작성했습니다.

결과를 보면 다음과 같습니다.

[https://t1.daumcdn.net/cfile/tistory/9942174A5AAE582034](https://t1.daumcdn.net/cfile/tistory/9942174A5AAE582034)

두 방법 모두 같은 결과를 얻습니다.

즉, 애트리뷰트 명을 잘 작성했다면 두 번째 방법으로 사용하는 것이 간단하므로 좋을 것입니다.

그런데 서로 다른 영역에 같은 이름을 갖는 애트리뷰트가 있다면 어떤 영역의 애트리뷰트가 선택될까요?

스코프 범위에 따라, **애트리뷰트 명은 좁은 범위의 영역부터 큰 범위의 영역으로 탐색**을 합니다.

즉, page  ->  request  -> session  -> application  순으로 탐색을 하며, 탐색이 된다면 더 이상 큰 범위로 탐색을 진행하지 않습니다.

이상으로 객체 Scope에 대해 알아보았습니다.
