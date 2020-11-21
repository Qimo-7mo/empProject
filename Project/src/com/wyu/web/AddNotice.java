package com.wyu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyu.pojo.Notice;
import com.wyu.service.NoticeService;
import com.wyu.service.NoticeServiceImpl;

public class AddNotice extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String noticeName = request.getParameter("noticeName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("noticeName--->" + noticeName);
		System.out.println("title--->" + title);
		System.out.println("content--->" + content);
		//System.out.println("哈哈哈哈哈哈哈");
		//===================================  开始  ===========================
		NoticeService service = new NoticeServiceImpl();
		Notice notice = new Notice();
		notice.setName(noticeName);
		notice.setContent(content);
		//将数据完成添加操作，是调用service层
		int in = service.insertNotice(notice);
		if(in>0) {
			System.out.println("公告添加成功");
			response.getWriter().append("公告名称：" + noticeName + "<br><br>公告主题" + title + "<br><br>内容：<br><br>" + content);
			return;//结束了
		}
		//如果失败了，就跳转到这个界面
		request.getRequestDispatcher("addNotice.jsp").forward(request,response);
		//===================================  结束  ===========================
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
	
}
