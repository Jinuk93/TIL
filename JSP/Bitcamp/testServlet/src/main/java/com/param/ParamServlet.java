package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}
	public void destroy() {
		System.out.println("destroy()");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
	
	//데이터	
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	//응답
	response.setContentType("text/html;charset=UTF-8"); //이제부터 코드를 html로 읽어라!, 한글로 읽어라!
	//response 에서 charset=UTF-8은 '웹 브라우저의 인코딩 방식을 저렇게 함으로써, 한글이 안꺠지게한다'
	PrintWriter out = response.getWriter(); // '웹'으로 출력하는 방식
	out.println("<html>"); // <html>을 출력한다
	out.println("<head>");
	out.println("</head>"); 
	out.println("<body>"); 
	out.println("</body>"); 
	out.println("Hello Servlet!!");
	out.println("<br><br>");
	
	out.println(name+"님의 나이는"+ age + "살 이므로" );
	if(age >= 19) out.println("성인 입니다");
	else out.println("청소년 입니다");
	
	out.println("</html>"); 
	}
}
