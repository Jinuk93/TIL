package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("서블릿클래스에서 제일먼저 실행되는 init() 메소드입니다");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException ,IOException {
		System.out.println("Client에서 요청이 있을때마다, 호출(응답)하는 메소드입니다");
		
		response.setContentType("text/html"); //이제부터 쓰는 내용을 html로 인식하여라!
		PrintWriter out = response.getWriter(); // 웹 브라우저로 출력하라!
	}
	
	public void destroy() {
		System.out.println("Servlet이 죽을때(종료될 때) 호출되는 메소드입니다");
	}
}
