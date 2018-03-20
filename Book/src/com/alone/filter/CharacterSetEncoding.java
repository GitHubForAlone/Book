package com.alone.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * @author object
 */
@WebFilter("/*")
public class CharacterSetEncoding implements Filter {

	public CharacterSetEncoding() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* 编码设置 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
