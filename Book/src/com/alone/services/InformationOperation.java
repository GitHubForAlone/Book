package com.alone.services;

import java.util.List;

import com.alone.domain.UserInformation;
import com.alone.services.impl.InformationOperationAchieve;

public interface InformationOperation {

	/**
	 * 返回一个本接口实现类对象
	 * 
	 * @return
	 */
	public static InformationOperationAchieve informationOperationAchieve() {
		return new InformationOperationAchieve();
	}

	/**
	 * 查询是否存在此用户 或者 查询用户名和密码是否匹配
	 * 
	 * @param args
	 * @return
	 */
	public boolean judgmentUserNameOrPassword(String... args);

	/**
	 * 注册信息
	 * 
	 * @param userInformation
	 * @return
	 */
	public boolean register(UserInformation userInformation);

	/**
	 * 查询数据库中的用户信息 参数1 则查询指定用户信息 不写参数则是所有用户信息
	 * 
	 * @param args
	 * @return
	 */
	public List<UserInformation> getUserInformation(String... args);

}
