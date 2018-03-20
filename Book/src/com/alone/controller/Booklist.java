package com.alone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alone.domain.BookClassAndBookInfomation;
import com.alone.domain.BookInfomation;
import com.alone.domain.Pagination;
import com.alone.services.InformationPagination;
import com.alone.util.IsBlank;

@WebServlet("/Booklist.alone")
/**
 * @author object
 */
public class Booklist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Booklist() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InformationPagination informationPagination = InformationPagination.informationPaginationAchieve();
		String classId = request.getParameter("classId");
		String className = request.getParameter("className");
		String pageName = "bookList";
		request.setAttribute("classId",classId);
		request.setAttribute("className",className);
		int defaultNumber = 10;
		Pagination.setPagination(pageName, request, informationPagination,defaultNumber,classId);
		int line = Pagination.getLine();
		int pageSize = Pagination.getPageSize();
		if (IsBlank.isBlank(classId) && IsBlank.isBlank(className)) {
			BookClassAndBookInfomation bookClassAndBookInfomation = new BookClassAndBookInfomation();
			List<BookInfomation> bookInfomation = informationPagination.getBookList(classId, line, pageSize);
			ServletContext servletContext = getServletContext();
			bookClassAndBookInfomation.setClassName(className);
			bookClassAndBookInfomation.setBooklist(bookInfomation);
			servletContext.setAttribute("bookClassNameAndBooklist", bookClassAndBookInfomation);
			request.getRequestDispatcher("/WEB-INF/view/booklist.jsp").forward(request, response);
		}
	}

}
