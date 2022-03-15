package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Jinuk extends HttpServlet{

	@Override //service �Լ��� �������̵�
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// resp.setCharacterEncoding("UTF-8");
		// ���ڵ��� ���������� ����� ??�� ���
		// ���ڵ��� UTF-8�� �������� ��t���� ���
		// ���ڵ��� CharacterEncoding�� ���Ҿ�, ContentType�� �ۼ��ؾ�
		// ������������ ������ �ؼ����� �ѱ��� ���������� ��µȴ�
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8" );
		
		PrintWriter out = resp.getWriter(); 
		//resp�� response '����'�̴�, req�� request '��û'
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		for(int i=0; i<cnt; i++) {
			out.print((i+1)+": �ȳ�<br >"); //�ٵ� <br>�±׸� "���ڿ�"�ȿ��ٰ� �ִ´�?
		}
		
	}
} 

//���༺��!
