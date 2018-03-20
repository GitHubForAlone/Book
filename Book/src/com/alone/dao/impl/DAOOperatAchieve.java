package com.alone.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.alone.dao.DAOOperating;
import com.alone.domain.UserInformation;
import com.alone.util.DbUtils;
import com.alone.util.IsBlank;
import com.alone.util.Md5Encod;

public class DAOOperatAchieve implements DAOOperating {
	/**
	 * 查询数据库中是否存在此用户 或者 查询用户名和密码是否匹配
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean selectUserNameOrPassword(String...args) throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		String[] clone = args.clone();
		String sql = null;
		Object query = null;
		boolean result = false;
		switch (clone.length) {//根据参数个数选择查询方式
			case 1://
				sql = "select name from book_user where name=?";
				query = runner.query(sql,new ScalarHandler(),clone[0]);
				break;
			case 2:
				sql = "select name,password from book_user where name=? and password=?";
				clone[1] = Md5Encod.getMD5(clone[1]);//数据库是由MD5加密，故，现将登录密码加密后查询
				query = runner.query(sql,new ScalarHandler(),clone[0],clone[1]);
				break;
			default:
				throw new RuntimeException("参数设置错误");
		}
		result = IsBlank.isBlank(query);
		return result;
	}

	/**
	 * 注册用户，向数据库插入用户信息
	 * @param userInformation
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean registerInsertInto(UserInformation userInformation) throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		String sql = "INSERT INTO book_user values(?,?,?,?,?,?)";
		String id = userInformation.getId();
		String name = userInformation.getName();
		String password = userInformation.getPassword();
		String tel = userInformation.getTel();
		String cardId = userInformation.getCardId();
		String registerDate = userInformation.getRegisterDate();
		int updata = runner.update(sql,id,name,password,tel,cardId,registerDate);
		boolean affected = false;
		if(updata>0) {
			affected = true;
		}
		return affected;
	}

	/**
	 * 查询所有书的类型
	 * @return
	 * @throws SQLException
	 */
	/*@Override
	public List<BookClassAndId> selectBookClass() throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		String sql = "select * from book_class";
		List<BookClassAndId> bookClass = runner.query(sql, new BeanListHandler<BookClassAndId>(BookClassAndId.class));
		return bookClass;
	}*/

	/**
	 * 查询指定类型书的列表
	 * @param classId
	 * @return
	 * @throws SQLException
	 */
	/*@Override
	public List<ClassBookList> selectBookList(String classId) throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		String sql = "select * from book_name where id=?";
		List<ClassBookList> bookClass = runner.query(sql, new BeanListHandler<ClassBookList>(ClassBookList.class),classId);
		return bookClass;
	}*/

	/**
	 * 查询用户信息
	 * 参数户名则返回单个用户的信息
	 * 不写参数则是查询所有用户信息
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<UserInformation> selectUserInformation(String...args) throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		String[] clone = args.clone();
		List<UserInformation> information = null;
		String sql = null;
		switch (clone.length) {
		case 1:
			sql = "select * from book_user where name=?";
			information = runner.query(sql, new BeanListHandler<UserInformation>(UserInformation.class),clone[0]);
			break;
		default:
			sql = "select * from book_user";
			information = runner.query(sql, new BeanListHandler<UserInformation>(UserInformation.class));
			break;
		}
		
		return information;
	}
	

}
