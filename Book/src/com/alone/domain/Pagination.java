package com.alone.domain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alone.services.InformationPagination;
import com.alone.util.IsBlank;

public class Pagination {
	//数据库读取初始位置
	private static int line;
	//页面显示数据数量
	private static int pageSize;
	
	private static final String INDEX = "index";
	private static final String BOOK_LIST = "bookList";
	
	private Pagination() {
	}
	
	/**
	 * 设置分页和当前页
	 * @param request
	 * @param informationPagination
	 */
	public static void setPagination (String pageName,HttpServletRequest request,InformationPagination informationPagination,int defaultNumber,String...args) {
		//从数据库第几行开始查询
				line = 0;
				//数据库查询行数
				pageSize = defaultNumber;
				HttpSession session = request.getSession();
				String rPageSize = request.getParameter("pageSize");
				String rPageNumber = request.getParameter("pageNumber");
				//主页显示数据数量
				if(IsBlank.isBlank(rPageSize)) {
					//先从请求参数拿页面数据数
					pageSize = Integer.parseInt(rPageSize);
				}else if(IsBlank.isBlank(session.getAttribute(pageName+"PageSize"))) {
					//从session中拿页面数据条数
					pageSize = (int) session.getAttribute(pageName+"PageSize");
				}else if("index".equals(pageName)){
					//默认显示3条
					pageSize = 3;
				}else {
					pageSize = 10;
				}
				if(pageSize>20) {
					//页面显示最多不超过20条数据
					pageSize=20;
				}
				//主页的初始页面
				if(IsBlank.isBlank(rPageNumber)) {
					line = Integer.parseInt(rPageNumber) * pageSize - pageSize;
				}else {
					rPageNumber = "1";
				}
				/**
				 * else if(IsBlank.isBlank(session.getAttribute(pageName+"PageNumber"))) {
					rPageNumber = (String) session.getAttribute(pageName+"PageNumber");
					//数据库从第line行开始查询
					line = Integer.parseInt(rPageNumber) * pageSize - pageSize;
				}
				 */
				//判断是哪个页面的请求，来选择统计的表
				long countNumber = 0;
				if(IsBlank.isBlank(pageName) && pageName.equals(INDEX)) {
					countNumber = informationPagination.countClassNumber();
				}else if(IsBlank.isBlank(pageName) && pageName.equals(BOOK_LIST)){
					countNumber = informationPagination.countBookNumber(args[0]);
				}
				//计算分页页数
				long pageNumber = countNumber / pageSize;
				if(countNumber % pageSize != 0 && countNumber % pageSize < pageSize) {
					//总页数
					pageNumber+=1;
				}
				
				//当改变页面显示数量是可能会出现当前页数乘以显示数会大于数据库数据数量，导致页面为空
				if(Integer.parseInt(rPageNumber) * pageSize > countNumber) {
					rPageNumber = pageNumber+"";
					line = Integer.parseInt(rPageNumber) * pageSize - pageSize;
				}
				//设置每页显示数量
				session.setAttribute(pageName+"PageSize",pageSize);
				//主页的总页数
				session.setAttribute(pageName+"AllPageNumber",pageNumber);
				//当前页
				session.setAttribute(pageName+"PageNumber",rPageNumber);
	}
	/**
	 * 获取数据库起始行数
	 * @return
	 */
	public static int getLine() {
		return line;
	}
	
	/**
	 * 页面显示数量
	 * @return
	 */
	public static int getPageSize() {
		return pageSize;
	}
	
}
