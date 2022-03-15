package com.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	private void init() throws ServletException {
		System.out.println("서블릿클래스에서 제일먼저 실행되는 init() 메소드입니다");
	}
	
	@Override
	private void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException ,IOException {
		
		System.out.println("Client에서 요청이 있을때마다, 호출(응답)하는 메소드입니다");
	}
	
	@Override
	private void destroy() {
		System.out.println("Servlet이 죽을때(종료될 때) 호출되는 메소드입니다");
	}
}
