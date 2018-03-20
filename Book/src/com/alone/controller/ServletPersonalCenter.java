package com.alone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alone.domain.UserInformation;
import com.alone.services.InformationOperation;
import com.alone.services.impl.InformationOperationAchieve;
import com.alone.util.IsBlank;

@WebServlet("/PersonalCenter.alone")
public class ServletPersonalCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletPersonalCenter() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user = request.getParameter("user");
		if(IsBlank.isBlank(user)) {
			InformationOperationAchieve informationOperationAchieve = InformationOperation.informationOperationAchieve();
			List<UserInformation> userInformation = informationOperationAchieve.getUserInformation(user);
			request.setAttribute("information", userInformation.get(0));
		}
		request.getRequestDispatcher("/WEB-INF/PersonalCenter/personal.jsp").forward(request, response);
	}

}
