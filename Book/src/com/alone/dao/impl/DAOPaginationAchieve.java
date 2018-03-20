package com.alone.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.alone.dao.DAOPagination;
import com.alone.domain.BookClassInfomation;
import com.alone.domain.BookInfomation;
import com.alone.util.DbUtils;

public class DAOPaginationAchieve implements DAOPagination {
	/**
	 * 查询此类型书的数量，排除数量为0的书
	 */
	@Override
	public long countBookNumber(String classId) throws SQLException {
		String sql = "SELECT COUNT(1) FROM BOOK_NAME WHERE ID = ? AND num!=0";
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		long number = (long)runner.query(sql,new ScalarHandler(),classId);
		return number;
	}

	/**
	 * 查询指定类型书籍
	 */
	@Override
	public List<BookInfomation> getBookInfomation(String classId,int line ,int number) throws SQLException{
		String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM BOOK_NAME WHERE id = ? AND num!=0 LIMIT ?,?";
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		List<BookInfomation> bookInfomation = runner.query(sql,new BeanListHandler<BookInfomation>(BookInfomation.class),classId,line,number);
		return bookInfomation;
	}

	/**
	 * 查询书的种类数量
	 */
	@Override
	public long countClassNumber() throws SQLException {
		String sql = "SELECT COUNT(1) FROM BOOK_CLASS";
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		long number = (long)runner.query(sql,new ScalarHandler());
		return number;
	}
	
	/**
	 * 查询书类 以及 类ID
	 */
	@Override
	public List<BookClassInfomation> getBookClass(int line,int number) throws SQLException {
		QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
		String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM BOOK_CLASS LIMIT ?,?";
		List<BookClassInfomation> bookClass = runner.query(sql, new BeanListHandler<BookClassInfomation>(BookClassInfomation.class),line,number);
		return bookClass;
	}
	
//	@Test
//	public void test() throws SQLException {
//		long countIDNumber = countBookNumber("570e2f3839174ee9b37dceeca7850d72");
//		System.out.println(countIDNumber);
//		long countClassNumber = countClassNumber();
//		System.out.println(countClassNumber);
//		List<ClassBookList> bookInfomation = getBookInfomation("570e2f3839174ee9b37dceeca7850d72",10, 10);
//		for (ClassBookList classBookList : bookInfomation) {
//			System.out.println(classBookList.getBookId()+","+classBookList.getName()+","+classBookList.getNum());
//		}
//		List<BookClassAndId> bookClass = getBookClass(3,2);
//		for (BookClassAndId bookClassAndId : bookClass) {
//			System.out.println(bookClassAndId.getId()+","+bookClassAndId.getName());
//		}
//	}
}
