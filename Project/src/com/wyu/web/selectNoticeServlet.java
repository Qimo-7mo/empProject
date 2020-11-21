package com.wyu.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.wyu.mapper.NoticeMapper;
import com.wyu.pojo.Notice;
import com.wyu.pojo.NoticeExample;
import com.wyu.util.MybatisUtil;

/**
 * Servlet implementation class selectNoticeServlet
 */
@WebServlet("/selectNoticeServlet")
public class selectNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
				request.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
		SqlSession session = MybatisUtil.getSession();
		NoticeMapper mapper = session.getMapper(NoticeMapper.class);
		
		NoticeExample example = new NoticeExample();
		List<Notice> list = mapper.selectByExampleWithBLOBs(example);
		list.forEach(li->System.out.println(li));
		
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		response.getWriter().write(jsonString);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
