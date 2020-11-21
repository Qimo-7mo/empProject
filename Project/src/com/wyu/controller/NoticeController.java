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

	//��ӹ���
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
		//System.out.println("��������������");
		//===================================  ��ʼ  ===========================
		NoticeService service = new NoticeServiceImpl();
		Notice notice = new Notice();
		
		notice.setId(id);
		notice.setUsername(username);
		notice.setTitle(title);
		notice.setName(noticeName);
		notice.setContent(content);
		//�����������Ӳ������ǵ���service��
		int in = service.insertNotice(notice);
		System.out.println("--------------"+in);
		
		if(in>0) {
			System.out.println("������ӳɹ�");
			//response.getWriter().append("�������ƣ�" + noticeName + "<br><br>��������" + title + "<br><br>���ݣ�<br><br>" + content);
			return "main";//������
		}
		//���ʧ���ˣ�����ת���������
		
		request.getRequestDispatcher("addNotice").forward(request,response);
		//===================================  ����  ===========================
		return "addNotice";
	}
	
}
