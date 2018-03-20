package com.alone.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.alone.dao.DAOOperating;
import com.alone.dao.impl.DAOOperatAchieve;
import com.alone.domain.UserInformation;
import com.alone.services.InformationOperation;

public class InformationOperationAchieve implements InformationOperation {

	DAOOperating dAOOperating = new DAOOperatAchieve();
	/**
	 * 判断用户或用户and密码是否存在
	 */
	@Override
	public boolean judgmentUserNameOrPassword(String... args) {
		boolean selectUserNameOrPassword = false;
		try {
			selectUserNameOrPassword = dAOOperating.selectUserNameOrPassword(args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectUserNameOrPassword;
	}

	/**
	 * 用户注册
	 */
	@Override
	public boolean register(UserInformation userInformation) {
		boolean registerInsertInto = false;
		try {
			registerInsertInto = dAOOperating.registerInsertInto(userInformation);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registerInsertInto;
	}

	/**
	 * 获取用户信息，
	 * 单个用户则返回单个用户信息，
	 * 省略则所有用户
	 */
	@Override
	public List<UserInformation> getUserInformation(String... args) {
		List<UserInformation> selectUserInformation = null;
		try {
			selectUserInformation = dAOOperating.selectUserInformation(args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectUserInformation;
	}

}
