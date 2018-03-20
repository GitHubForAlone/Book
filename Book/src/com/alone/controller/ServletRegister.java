package com.alone.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alone.domain.UserInformation;
import com.alone.services.InformationOperation;
import com.alone.services.impl.InformationOperationAchieve;
import com.alone.util.IsBlank;
import com.alone.util.PatternMatcher;

/**
 * @author object
 */
@WebServlet("/Register.alone")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PASSWORD_LENGTH = 8;
	private static final int USER_LENGTH = 3;
	public ServletRegister() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String telephone = request.getParameter("telephone");//
		String cardId = request.getParameter("cardId");
		System.out.println(username+ "  " +password +"   "+ repassword +"   "+ telephone + "  " + cardId);
		// 是否有空表单
		boolean tableNotIsNull = IsBlank.isBlank(username) && IsBlank.isBlank(password) && IsBlank.isBlank(repassword) && IsBlank.isBlank(telephone) && IsBlank.isBlank(cardId);
		
		if(!tableNotIsNull) {
			response.sendRedirect(request.getContextPath() + "/register.jsp");
			return;
		}
		
		//判断身份证号码 和 电话号码格式是否正确
		boolean isOk = PatternMatcher.pMString(telephone,cardId);
		System.out.println(isOk);
		// 两次密码输入是否相同
		boolean passwordAndRepasswordIsTrue = password.equals(repassword);
		System.out.println(passwordAndRepasswordIsTrue);
		// 密码是否与用户名相同
		boolean passwordNotIsUserName = !(username.equals(password) || username.equals(repassword));
		System.out.println(passwordNotIsUserName);
		// 用户名和密码的长度是否满足条件
		boolean passwordLength = username.length() >= USER_LENGTH && password.length() >= PASSWORD_LENGTH;
		System.out.println(passwordLength);
		if (isOk && passwordAndRepasswordIsTrue && passwordNotIsUserName && passwordLength) {
			InformationOperationAchieve informationOperation = InformationOperation.informationOperationAchieve();
			String id = UUID.randomUUID().toString().replace("-","");
			Date d = new Date();
			String date = d.toString();
			System.out.println(id+ "  " +username+ "  " +password+ "  " +telephone+ "  " +cardId+ "  " + date);
			UserInformation userInformation = new UserInformation();
			userInformation.setId(id);
			userInformation.setName(username);
			userInformation.setPassword(password);
			userInformation.setTel(telephone);
			userInformation.setCardId(cardId);
			userInformation.setRegisterDate(date);
			boolean register = informationOperation.register(userInformation);
			// 注册信息
			if (register) {
				response.sendRedirect(request.getContextPath() + "/login.alone");
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/register.alone");
	}

}
