package com.htmtennis.prj;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ChracterEncodingFilter implements Filter{
	private String encoding;
	
	@Override
	public void destroy() {	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("before ���Ͷ��");		
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		//System.out.println("after ���Ͷ��");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");		
	}
}
