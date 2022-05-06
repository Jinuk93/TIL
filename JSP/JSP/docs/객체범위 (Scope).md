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

![다운로드](https://user-images.githubusercontent.com/80089860/167165186-48371736-92e6-474b-b84e-8d5c93b1713e.jpg)



