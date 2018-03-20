package com.alone.dao;

import java.sql.SQLException;
import java.util.List;

import com.alone.domain.BookClassInfomation;
import com.alone.domain.BookInfomation;

public interface DAOPagination {
	/**
	 * 根据ID，统计数据库指定类书数量
	 * @return
	 */
	public long countBookNumber(String classId) throws SQLException;
	

	/**
	 * 查询书的种类数量
	 */
	public long countClassNumber() throws SQLException;
	
	/**
	 * 查询所有类
	 * @return
	 * @throws SQLException
	 */
	List<BookClassInfomation> getBookClass(int line, int number) throws SQLException;
	
	
	/**
	 * 根据ID，根据查询数量，根据页数查询书籍信息。
	 * @return
	 */
	public List<BookInfomation> getBookInfomation(String classId,int line ,int number) throws SQLException;


	
	
}
