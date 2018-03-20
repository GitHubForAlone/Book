package com.alone.dao;

import java.sql.SQLException;
import java.util.List;
import com.alone.domain.UserInformation;

public interface DAOOperating {
	/**
	 * 查询数据库中是否存在此用户 或者 查询用户名和密码是否匹配
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public boolean selectUserNameOrPassword(String... args) throws SQLException;

	/**
	 * 注册用户，向数据库插入用户信息
	 * @param userInformation
	 * @return
	 * @throws SQLException
	 */
	public boolean registerInsertInto(UserInformation userInformation) throws SQLException;

	/**
	 * 查询所有书的类型
	 * @return
	 * @throws SQLException
	 */
	//public List<BookClassAndId> selectBookClass() throws SQLException;

	/**
	 * 查询指定类型书的列表
	 * @param classId
	 * @return
	 * @throws SQLException
	 */
	//public List<ClassBookList> selectBookList(String classId) throws SQLException;

	/**
	 * 查询用户信息
	 * 参数户名则返回单个用户的信息
	 * 不写参数则是查询所有用户信息
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public List<UserInformation> selectUserInformation(String... args) throws SQLException;
}
