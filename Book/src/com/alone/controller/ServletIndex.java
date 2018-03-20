package com.alone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alone.domain.BookClassInfomation;
import com.alone.domain.BookClassInfomationAndBookList;
import com.alone.domain.BookInfomation;
import com.alone.domain.Pagination;
import com.alone.services.InformationPagination;

@WebServlet("/index.alone")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletIndex() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InformationPagination informationPagination = InformationPagination.informationPaginationAchieve();
		String pageName = "index";
		int defaultNumber = 3;
		Pagination.setPagination(pageName, request, informationPagination,defaultNumber);
		int line = Pagination.getLine();
		int pageSize = Pagination.getPageSize();
		List<BookClassInfomation> bookClass = informationPagination.getBookClass(line, pageSize);
		List<BookClassInfomationAndBookList> viewBook = new ArrayList<BookClassInfomationAndBookList>();
		ServletContext servletContext = getServletContext();
		
		//向页面展示书籍简略信息
		int BriefInformation = 3;
		for (BookClassInfomation bookClassInfomation : bookClass) {
			BookClassInfomationAndBookList bookClassInfomationAndBookList = new BookClassInfomationAndBookList();
			String classid = bookClassInfomation.getId();
			String className = bookClassInfomation.getName();
			List<BookInfomation> bookInfomation = informationPagination.getBookList(classid, line, BriefInformation);
			bookClassInfomationAndBookList.setClassID(classid);
			bookClassInfomationAndBookList.setClassName(className);
			bookClassInfomationAndBookList.setBookList(bookInfomation);
			viewBook.add(bookClassInfomationAndBookList);
		}
		servletContext.setAttribute("viewBook", viewBook);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}