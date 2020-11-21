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
		//�����������
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String noticeName = request.getParameter("noticeName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("noticeName--->" + noticeName);
		System.out.println("title--->" + title);
		System.out.println("content--->" + content);
		//System.out.println("��������������");
		//===================================  ��ʼ  ===========================
		NoticeService service = new NoticeServiceImpl();
		Notice notice = new Notice();
		notice.setName(noticeName);
		notice.setContent(content);
		//�����������Ӳ������ǵ���service��
		int in = service.insertNotice(notice);
		if(in>0) {
			System.out.println("������ӳɹ�");
			response.getWriter().append("�������ƣ�" + noticeName + "<br><br>��������" + title + "<br><br>���ݣ�<br><br>" + content);
			return;//������
		}
		//���ʧ���ˣ�����ת���������
		request.getRequestDispatcher("addNotice.jsp").forward(request,response);
		//===================================  ����  ===========================
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
	
}
