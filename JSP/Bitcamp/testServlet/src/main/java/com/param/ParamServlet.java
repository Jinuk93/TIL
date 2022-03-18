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
	
	//������	
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	//����
	response.setContentType("text/html;charset=UTF-8"); //�������� �ڵ带 html�� �о��!, �ѱ۷� �о��!
	//response ���� charset=UTF-8�� '�� �������� ���ڵ� ����� ������ �����ν�, �ѱ��� �ȃ������Ѵ�'
	PrintWriter out = response.getWriter(); // '��'���� ����ϴ� ���
	out.println("<html>"); // <html>�� ����Ѵ�
	out.println("<head>");
	out.println("</head>"); 
	out.println("<body>"); 
	out.println("</body>"); 
	out.println("Hello Servlet!!");
	out.println("<br><br>");
	
	out.println(name+"���� ���̴�"+ age + "�� �̹Ƿ�" );
	if(age >= 19) out.println("���� �Դϴ�");
	else out.println("û�ҳ� �Դϴ�");
	
	out.println("</html>"); 
	}
}
