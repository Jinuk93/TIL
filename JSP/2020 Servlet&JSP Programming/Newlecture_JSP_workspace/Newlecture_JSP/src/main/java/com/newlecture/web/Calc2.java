package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String value_ = request.getParameter("value");
		String op = request.getParameter("operate");
		
		int value = 0;
		
		if(!value_.equals("")) value = Integer.parseInt(value_);
		
		if(op.equals("=")) {
			
			//int x = (Integer)application.getAttribute("value"); //get은 꺼낼것
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			
			int y = value;
			//String operator = (String)application.getAttribute("op");;
			//String operator = (String)session.getAttribute("op");

			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			
			if(op.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			response.getWriter().printf("result is %d\n", result);

		}else {
			/*
			<어플리케이션>
			application.setAttribute("value", value); //map 컬렉션(key, value)와 같이 저장한다.
			application.setAttribute("op", op);
			<세션>
			session.setAttribute("value", value);  //map 컬렉션(key, value)와 같이 저장한다.
			session.setAttribute("op", op);*/
		 
		 // <쿠키 객체 2개생성>
			Cookie valueCookie = new Cookie("value", String.valueOf(value));
			Cookie opCookie = new Cookie("op", op);
		 // <쿠키를 Client에게 보낸다>
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
		}
	}
}
