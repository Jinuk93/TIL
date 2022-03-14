# 09. 서블릿(Servlet) 문자열 출력

---

**HttpServletRequest - 입력 도구, 요청객체**

**HttpServletResponse - 출력 도구, 응답객체**

<aside>
⭐ Stream으로 출력

</aside>

**OutputStream os = response.getOutputStream();** 

**//byte단위의 입,출력시 Stream 사용**

**PrintStream out = new PrintStream(os, true);** 

 **//true는 버퍼를 채울때까지 기다리지 말고 print했을때 바로 출력하게 하는 옵션**

**//문자열(String 타입) 출력을 편하게 쓰는 PrintStream 사용**

<aside>
⭐ Writer으로 출력

</aside>

**PrintWriter out = response.getWriter();**

**out.println("Hello Servlet"); // 이클립스 콘솔창이 아닌, 원격인 Client한테 출력된다**

---

😬

**이클립스같은 통합개발환경을 안 썼다는 가정하에,**

**코드를 수정하게 된다면**

**컴파일을 매번 다시해야하고, 배포 또한 다시해야하고, 서버 재실행, 브라우저 띄어서 주소입력해서**

**실행하는 등의 과정을 매번 다시 해야하는 번거로움이 있다**

**따라서, 이클립스같은 통합개발환경의 편리성을 다시한번 깨닫게된다.**
