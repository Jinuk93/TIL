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
		System.out.println("����Ŭ�������� ���ϸ��� ����Ǵ� init() �޼ҵ��Դϴ�");
	}
	
	@Override
	private void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException ,IOException {
		
		System.out.println("Client���� ��û�� ����������, ȣ��(����)�ϴ� �޼ҵ��Դϴ�");
	}
	
	@Override
	private void destroy() {
		System.out.println("Servlet�� ������(����� ��) ȣ��Ǵ� �޼ҵ��Դϴ�");
	}
}
