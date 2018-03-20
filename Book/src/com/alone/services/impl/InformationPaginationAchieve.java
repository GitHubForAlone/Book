package com.alone.services.impl;

import java.sql.SQLException;
import java.util.List;
import com.alone.dao.DAOPagination;
import com.alone.dao.impl.DAOPaginationAchieve;
import com.alone.domain.BookClassInfomation;
import com.alone.domain.BookInfomation;
import com.alone.services.InformationPagination;

public class InformationPaginationAchieve implements InformationPagination {

	DAOPagination dAOPagination = new DAOPaginationAchieve();
	/**
	 * 查询书类表的 种类 和 ID信息
	 */
	@Override
	public List<BookClassInfomation> getBookClass(int line ,int number) {
		List<BookClassInfomation> allBookClass = null;
		try {
			allBookClass = dAOPagination.getBookClass(line, number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookClass;
	}

	/**
	 * 根据书类ID
	 */
	@Override
	public List<BookInfomation> getBookList(String classId,int line,int number) {
		List<BookInfomation> selectBookList = null;
		try {
			selectBookList = dAOPagination.getBookInfomation(classId, line, number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectBookList;
	}
	
	/**
	 * 统计指定类型书籍的书量
	 */

	@Override
	public long countBookNumber(String classId){
		long countBookNumber = 0;
		try {
			countBookNumber = dAOPagination.countBookNumber(classId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countBookNumber;
	}

	
	/**
	 * 统计书的种类数量
	 */
	@Override
	public long countClassNumber() {
		long countClassNumber = 0;
		try {
			countClassNumber = dAOPagination.countClassNumber();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countClassNumber;
	}
}
