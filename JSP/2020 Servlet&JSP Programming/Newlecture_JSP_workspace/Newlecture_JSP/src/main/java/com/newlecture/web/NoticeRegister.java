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
		
		resp.setCharacterEncoding("UTF-8"); //response ��� �ѱ�ó��
		resp.setContentType("text/html; charset=UTF-8" );
		
		/* req.setCharacterEncoding("UTF-8"); //request ��� �ѱ�ó�� */		
		
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println(title);
		out.println(content);
		//������ src/main/Java�� �ƴ� register.html �ʿ��� �����ؾ��Ѵ�
		}		
	}

