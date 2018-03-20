package com.alone.domain;

import java.util.List;

public class BookClassInfomationAndBookList {
	/**
	 * 书的分类名称
	 */
	private String className;
	/**
	 * 书的分类ID
	 */
	private String classID;
	/**
	 * 当前分类下所有书籍
	 */
	private List<BookInfomation> bookInfomation;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public List<BookInfomation> getBookList() {
		return bookInfomation;
	}
	public void setBookList(List<BookInfomation> bookInfomation) {
		this.bookInfomation = bookInfomation;
	}
	
	
}
