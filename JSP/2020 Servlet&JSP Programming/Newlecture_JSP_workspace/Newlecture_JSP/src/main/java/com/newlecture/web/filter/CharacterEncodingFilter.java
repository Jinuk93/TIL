package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0
			,ServletResponse arg1
			, FilterChain arg2)
			throws IOException, ServletException {
		
	  //chain.doFilter(req, resp);
		System.out.println("필터가 동작되면 이 문구가 출력됩니다!");

	}

}
