package com.alone.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alone.util.IsBlank;

/**
 * @author object
 */
public class UserSessionVerification implements Filter {
	private String verificationURL;

	public UserSessionVerification() {

	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		boolean contains = verificationURL.contains(req.getServletPath());
		String userInformation = "userInformation";
		if (contains || IsBlank.isBlank(session.getAttribute(userInformation))) {
			chain.doFilter(request, response);
		}else {
			resp.sendRedirect(req.getContextPath() + "/login.alone");
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		verificationURL = fConfig.getInitParameter("VerificationURL");
	}

}
