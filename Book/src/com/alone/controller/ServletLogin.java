package com.alone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alone.domain.UserInformation;
import com.alone.services.InformationOperation;
import com.alone.services.impl.InformationOperationAchieve;
import com.alone.util.IsBlank;

/**
 * @author object
 */
@WebServlet("/Login.alone")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InformationOperationAchieve informationOperation = InformationOperation.informationOperationAchieve();
		// 登录验证
		response.getWriter().write("Login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 判断用户和密码是否为空
		if (IsBlank.isBlank(username) && IsBlank.isBlank(password)) {
			// 数据库中查询是否存在此用户和密码
			boolean isFind = informationOperation.judgmentUserNameOrPassword(username, password);
			if (isFind) {
				UserInformation userInformation = new UserInformation();
				userInformation.setName(username);
				userInformation.setPassword(password);
				HttpSession session = request.getSession();
				session.setAttribute("userInformation", userInformation);
				response.sendRedirect(request.getContextPath() + "/WEB-INF/view/index.alone");
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/login.alone");
	}

}
