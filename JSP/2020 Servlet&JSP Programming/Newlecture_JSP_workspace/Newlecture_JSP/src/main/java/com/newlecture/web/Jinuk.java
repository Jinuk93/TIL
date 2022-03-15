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

	@Override //service 함수를 오버라이드
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// resp.setCharacterEncoding("UTF-8");
		// 인코딩을 안했을때는 출력이 ??로 출력
		// 인코딩을 UTF-8로 했을때는 댐꿻으로 출력
		// 인코딩을 CharacterEncoding과 더불어, ContentType도 작성해야
		// 브라우저마다의 자의적 해석없이 한글이 정상적으로 출력된다
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8" );
		
		PrintWriter out = resp.getWriter(); 
		//resp는 response '응답'이다, req는 request '요청'
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		for(int i=0; i<cnt; i++) {
			out.print((i+1)+": 안녕<br >"); //근데 <br>태그를 "문자열"안에다가 넣는다?
		}
		
	}
} 

//실행성공!
