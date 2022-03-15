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
		System.out.println("����Ŭ�������� ���ϸ��� ����Ǵ� init() �޼ҵ��Դϴ�");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException ,IOException {
		System.out.println("Client���� ��û�� ����������, ȣ��(����)�ϴ� �޼ҵ��Դϴ�");
		
		response.setContentType("text/html"); //�������� ���� ������ html�� �ν��Ͽ���!
		PrintWriter out = response.getWriter(); // �� �������� ����϶�!
	}
	
	public void destroy() {
		System.out.println("Servlet�� ������(����� ��) ȣ��Ǵ� �޼ҵ��Դϴ�");
	}
}
