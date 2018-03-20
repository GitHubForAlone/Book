package com.alone.domain;

import java.util.List;

public class BookClassAndBookInfomation {
	//书类名
	private String className;
	//所有书籍
	private List<BookInfomation> booklist;
	
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<BookInfomation> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<BookInfomation> booklist) {
		this.booklist = booklist;
	}
	
}
