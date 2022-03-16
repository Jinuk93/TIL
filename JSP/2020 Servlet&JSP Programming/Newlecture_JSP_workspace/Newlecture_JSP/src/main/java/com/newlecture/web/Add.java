package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add") // form action 이름이 소문자 add라서 Mapping 해놓는다
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		int x = 0;
		int y = 0; // x,y값이 빈문자열이 아니게끔 0의 값을 먼저 준다
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		// x,y의 값이 빈 문자열이 아니면 x,y의 값을 정수형으로 타입변환하라!
		
		int result = x+y;
		
		response.getWriter().printf("result is %d\n", result);
		// printf 는 출력포맷이 포함되어야 한다? 예시. out.print("%d + %d = %d", x,y,x+y);
	}
}
