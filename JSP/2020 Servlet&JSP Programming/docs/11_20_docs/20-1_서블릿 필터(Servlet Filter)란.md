# 20-1. 서블릿 필터(Servlet Filter)란?

**서블릿 필터(Servlet Filter)란?**

**Client로 부터 Server로 요청이 들어오기 전에 서블릿을 거쳐서 필터링 하는 것을 서블릿 필터**라고 한다.

**Servlet과 거의 동일하지만 기능이 Filtering 이기 때문에 이렇게 이름이 지어졌다고 한다.**

**지금까지 Servlet은 HTTPServletRequest였다면 Filter는 ServletRequest이다.**

**Filter의 ServletRequest가 더 부모클래스이다**

****

***서블릿 필터란?***

사용자 인증이나 로깅과 같은 기능들은 모든 서블릿이나 JSP가 공통적으로 필요로 함.

이러한 **공통적인 기능들을 서블릿이 호출되기 전에 수행(전처리)되게 하고 싶거나**

**서블릿이 호출 되고 난 뒤에 수행(후처리) 하고 싶으면 공통적인 기능들을 서블릿 필터로 구현하면 된다.**

서블릿 필터는 서블릿 3.x 스펙부터 추가된 기술이다

클라이언트의 요청을 서블릿이 받기전에 먼저 가로채서

필터에 작성된 내용이 먼저 수행되도록 한다.

**따라서 필터를 사용하면 클라이언트의 요청을 가로채어서**

**서버컴포넌트의 공통적인 기능들을 수행시킬 수 있다.**

다음은 필터로 구현하면 좋은 기능들이다.

1. 인증(사용자 인증) 필터

2. 로깅 및 감시(Audit) 필터

3. 이미지 변환 및 데이터 압축 필터

4. 암호화 필터

5. XML 컨텐츠를 변형하는 XSLT 필터

6. URL 및 기타 정보들을 캐싱하는 필터

---

****

**Filter 인터페이스**

필터를 설정하는 FilterConfig 객체, FilterChain 객체와 Filter 객체가 필요하다.

이 중에서 FilterConfig 인터페이스랑 FilterChain 인터페이스를 상속받은 클래스들은 웹컨테이너가 구현해준다. Filter를 구현하는데 필요한 건 사용자 정의 필터 클래스는 javax.servlet.Filter 인터페이스를 구현한다. Filter 인터페이스는 init(), doFilter() , destroy() 메소드가 있다.

**init(FilterConfig config)**
서블릿 컨테이너가 필터 인스턴스를 초기화 하기 위해서 호출하는 메소드

**doFilter(ServletRequest res, ServletResponse res,FilterChain chain)**
필터에서 구현해야 하는 로직을 작성하는 메소드

**destroy() : void**
필터 인스턴스를 종료시키기 전에 호출하는 메소드

**Filter의 라이프 사이클**

필터는 서블릿과 비슷한 라이프사이클을 가지며 생성, 초기화, 필터, 종료의 4단계로 이루어짐

또한 서블릿 컨테이너는 필터 객체가 초기화 파라미터에 접근하는데 사용하는 환경설정 객체(FilterConfig)의 레퍼런스를 제공한다. 서블릿 컨테이너가 필터의 init() 메소드를 호출하면 필터 인터페이스는 바로 요청을 처리할 수 있는 상태가 된다.

서블릿이 service() 메소드를 이용해서 요청을 처리한 것 처럼 필터는 doFilter() 메소드를 통해서 요청을 처리한다. 모든 요청에 대한 처리가 끝나면 destroy() 메소드가 호출되면서 필터는 비활성 상태로 변경된다.

이 포스팅에서는 @(어노테이션)으로 설정할 예정이므로 web.xml 설정법을 알고 싶다면 구글링을 하기 바란다.

**FilterChain**

필터는 연속적인 작용을 수행한다. 필터 객체가 수행해야 할 부분인 doFilter() 메소드로 인자로 전달되는 것이 FilterChain 객체이다. FilterChain 객체는 필터의 수행과정을 연속적으로 하기 위한 방법이다. 웹 컨테이너가 FIlterConfig 객체와 함께 FilterChain 인터페이스를 구현한 객체를 생성한다.

**doFilter() 메소드**

가장 핵심인 Filtering이 이루어지는 메소드이다.

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	//여기에 전처리
	chain.doFilter(request, response);
	//여기에 후처리
}

필터는 한번만 수행되는 것이 아니라, 요청을 받을 때 수행되고 chain.doFilter()를 통해 다음 부분으로 넘겨준다. 그 다음 모든 부분이 모두 수행되면 다시 필터로 완전한 응답객체와 함께 제어권이 넘어오게 된다. 위의 코드처럼 chain.doFilter()를 기준으로 전처리 부분과 후처리 부분으로 나누는 이유다.

따라서 **chain.doFIlter()가 doFilter() 메소드 안에 없다면 서블릿의 수행결과를 알 수 없다.** 즉 chain,doFilter() 메소드를 사용하여 다음 단계인 진짜 서블릿을 수행한 후 결과를 다시 받는 것이다.

필터의 예제로 한글 처리하는 기능을 작성해보려고 한다.

```java
name.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dolphago Name page</title>
</head>
<body>
	<form action="output1" method="post">
		이름 : <input type="text" name="name">
		<input type="submit" value="확인">
	</form>
</body>
</html>

subject.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dolphago Subject page</title>
</head>
<body>
	<form action="output2" method="post">
		과목 : <input type= "text" name="subject">
		<input type="submit" value="확인">
	</form>
</body>
</html>

major.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dolphago major page</title>
</head>
<body>
	<form action="output3" method="post">
		전공 : <input type= "text" name="subject">
		<input type="submit" value="확인">
	</form>
</body>
</html>

output1Servlet

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/output1")
public class Output1Servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(request.getParameter("name"));
		out.close();
	}
}

output2 Servlet

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/output2")
public class Output2Servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(request.getParameter("subject"));
		out.close();
	}
}

output3 Servlet

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/output3")
public class Output3Servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(request.getParameter("major"));
		out.close();
	}
}

Filter

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class dolphagoFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//여기에 전처리
		request.setCharacterEncoding("UTF-8");
		System.out.println("doFilter() 전....");
		chain.doFilter(request, response);
		//여기에 후처리
		System.out.println("doFilter() 후....");
	}
	public void destroy() {	}
}
```

실행 결과

![https://mblogthumb-phinf.pstatic.net/MjAxOTEwMDJfODAg/MDAxNTY5OTcwNjE1Mzcw.uCYS10H2Jac4icxfA_uQmGaynO7GnwG0sR-28woO1BAg.K0GyqCBJ0-yCu6z4VDYtBjsaruwXeWCWazbWFssLq8Ug.PNG.adamdoha/image.png?type=w800](https://mblogthumb-phinf.pstatic.net/MjAxOTEwMDJfODAg/MDAxNTY5OTcwNjE1Mzcw.uCYS10H2Jac4icxfA_uQmGaynO7GnwG0sR-28woO1BAg.K0GyqCBJ0-yCu6z4VDYtBjsaruwXeWCWazbWFssLq8Ug.PNG.adamdoha/image.png?type=w800)

새로 고침을 누르면 요청이 들어온다는 것이니까 계속 필터가 돈다

![https://mblogthumb-phinf.pstatic.net/MjAxOTEwMDJfMTgz/MDAxNTY5OTcwODY2MTE3.OF63tnRcW-K1zUybsrgL8JIrP_TN3qcOVFGUMQ9U5e8g.I0O7hfm0P18-wh9gWiYD6Dfzsy0XMztwAV4wOg7Swsog.PNG.adamdoha/image.png?type=w800](https://mblogthumb-phinf.pstatic.net/MjAxOTEwMDJfMTgz/MDAxNTY5OTcwODY2MTE3.OF63tnRcW-K1zUybsrgL8JIrP_TN3qcOVFGUMQ9U5e8g.I0O7hfm0P18-wh9gWiYD6Dfzsy0XMztwAV4wOg7Swsog.PNG.adamdoha/image.png?type=w800)

그래서 구분하려고 Servlet안에서 콘솔창에 찍어봤다.

![https://mblogthumb-phinf.pstatic.net/MjAxOTEwMDJfMjY2/MDAxNTY5OTcwOTcwODQ1.pOIjt87_Snokg_u96OBvUaSNyUIY8qDs-J9KaDPotrUg.oNYgJjS2lzogWVC_iQdcP7qw58V8cwN8rLplZIyvgOIg.PNG.adamdoha/image.png?type=w800](https://mblogthumb-phinf.pstatic.net/MjAxOTEwMDJfMjY2/MDAxNTY5OTcwOTcwODQ1.pOIjt87_Snokg_u96OBvUaSNyUIY8qDs-J9KaDPotrUg.oNYgJjS2lzogWVC_iQdcP7qw58V8cwN8rLplZIyvgOIg.PNG.adamdoha/image.png?type=w800)

이름을 입력하고 확인을 누르면,

우선 필터를 먼저 만나서 doFilter() 전을 출력하면서

doFilter 전처리를 먼저 하고(요청 인코딩을 utf-8로)

그다음 output 서블릿에 들려서 PrintWriter로 출력하는 작업을 한 뒤에

다시 필터로 돌아와서 doFilter() 후를 출력하고 있음을 확인할 수 있다.