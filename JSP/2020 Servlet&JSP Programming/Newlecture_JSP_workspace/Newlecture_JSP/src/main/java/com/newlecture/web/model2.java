package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/model2")
public class model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
	request.setAttribute("r", result); 
	//서블릿단에서 result를 r이란 이름으로 담아두었다 -> JSP(뷰)에 작업물을 이전시키기 위해서!
	// JSP단에서 꺼내고 싶을 때, r이란 이름으로 result 변수를 가져다 쓸 수 있다
		
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("model2.jsp");
	dispatcher.forward(request, response); 
	}
}
