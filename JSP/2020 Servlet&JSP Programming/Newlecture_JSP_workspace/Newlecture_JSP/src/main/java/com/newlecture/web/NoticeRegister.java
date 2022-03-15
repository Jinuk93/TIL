package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-register")
public class NoticeRegister extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //response 방식 한글처리
		resp.setContentType("text/html; charset=UTF-8" );
		
		/* req.setCharacterEncoding("UTF-8"); //request 방식 한글처리 */		
		
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println(title);
		out.println(content);
		//실행은 src/main/Java가 아닌 register.html 쪽에서 실행해야한다
		}		
	}


