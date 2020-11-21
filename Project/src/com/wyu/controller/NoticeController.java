package com.wyu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyu.pojo.Notice;
import com.wyu.service.NoticeService;
import com.wyu.service.NoticeServiceImpl;

@Controller
public class NoticeController {

	//添加公告
	@RequestMapping(value="/addNotice")
	@ResponseBody
	public String addNotice(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		String noticeName = request.getParameter("noticeName");
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		
		String content = request.getParameter("content");
		System.out.println("noticeName--->" + noticeName);
		System.out.println("title--->" + title);
		System.out.println("username--->" + username);
		System.out.println("id--->" + id);
		System.out.println("content--->" + content);
		//System.out.println("哈哈哈哈哈哈哈");
		//===================================  开始  ===========================
		NoticeService service = new NoticeServiceImpl();
		Notice notice = new Notice();
		
		notice.setId(id);
		notice.setUsername(username);
		notice.setTitle(title);
		notice.setName(noticeName);
		notice.setContent(content);
		//将数据完成添加操作，是调用service层
		int in = service.insertNotice(notice);
		System.out.println("--------------"+in);
		
		if(in>0) {
			System.out.println("公告添加成功");
			//response.getWriter().append("公告名称：" + noticeName + "<br><br>公告主题" + title + "<br><br>内容：<br><br>" + content);
			return "main";//结束了
		}
		//如果失败了，就跳转到这个界面
		
		request.getRequestDispatcher("addNotice").forward(request,response);
		//===================================  结束  ===========================
		return "addNotice";
	}
	
}
