package com.alone.services;

import java.util.List;
import com.alone.domain.BookClassInfomation;
import com.alone.domain.BookInfomation;
import com.alone.services.impl.InformationPaginationAchieve;

public interface InformationPagination {
	/**
	 * 返回一个实现类对象
	 * @return
	 */
	public static InformationPaginationAchieve informationPaginationAchieve() {
		return new InformationPaginationAchieve();
	}

	
	/**
	 * 根据ID，统计数据库指定类书数量
	 * @return
	 */
	public long countBookNumber(String classId);
	
	/**
	 * 查询书的种类数量
	 */
	public long countClassNumber();
	
	/**
	 * 查询所有书的分类
	 * 
	 * @return
	 */
	public List<BookClassInfomation> getBookClass(int line ,int number);
	/**
	 * 查询指定分类的书籍
	 * 
	 * @param classId
	 * @return
	 */
	public List<BookInfomation> getBookList(String classId,int line,int number);
	
}
