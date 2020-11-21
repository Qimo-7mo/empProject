package com.wyu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyu.pojo.User;
import com.wyu.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	@RequestMapping("/login")
	public String login(String number,String password,HttpSession session,Model model) {
		
		//����service���е�login����
		User user = service.login(number);
		//�жϣ����������û����û���������󣬵�½�ɹ�
		String loginInfo = "�û�������";
		if(user!=null) {
			//System.out.println("�û�������");
			if(password.equals(user.getPassword())) {
				System.out.println("��½�ɹ�");
				session.setAttribute("user", user);
				//��½�ɹ������û���Ϣ���浽session���У�����ѹҳ�����,main
				return "main";
			}else {
				loginInfo = "�������";
				System.out.println("�������");
			}
		}
		model.addAttribute("loginInfo",loginInfo);
		return "index";
		
		
		//model.addAttribute("loginMS", "�Ҵ����ĵ�һ��ssm��Ŀ");
		//System.out.println("123456");
		//return "index";
	}
	
	//����û�
	@RequestMapping(value="/addUser")
	public String addUser(User user, Model model) {
		System.out.println("========>"+user);
		int in = service.addUser(user);
		String addInfo = "0";
		if(in>0) {
			System.out.println("��ӳɹ�");
			addInfo = "1";
		}
		//����ӵĽ����model�ŵ�request����
		model.addAttribute("addInfo",addInfo);
		
		return "addUsers";
	}

	//ɾ������
	@RequestMapping(value="/deleteUser",produces=("application/text;charset=utf-8"))
	@ResponseBody
	public String deleteUser(String number) {
		System.out.println("Ҫ�����number:"+number);
		
		//����service���ɾ��
		int in = service.deleteUser(number);
		String reInfo = "ɾ��ʧ��";
		if(in>0) {
			
			reInfo = "ɾ���ɹ�";
			System.out.println("ɾ���ɹ�");
		}
		return reInfo;
	}
	
	//�޸�����
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(User user) {
		System.out.println("=========="+user);
		
		//����service��������޸Ĳ���
		int in = service.updateUser(user);
		if(in>0) {
			System.out.println("�޸ĳɹ�");
			return "1";
		}
		
		return "0";
	}

	//��ҳ
	@RequestMapping(value="/findUsers", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findUsers(int page, int rows) {

		System.out.println("page==="+page+";rows===" + rows);
		// ʹ�÷�ҳ�����ɷ�ҳ��page-->��ǰҳ��rows--->��ѯ����
		PageHelper.startPage(page, rows);

		// ��ѯ��������
		List<User> list = service.findUsers();

		// ���õ������ݷ�װ��json����
		String listjson = JSON.toJSONString(list);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		System.out.println("�ܼ�¼��:"+total);

		list.forEach(li -> System.out.println(li));

		// �������ظ�ǰ�˵�json����

		String json = "{\"total\":" + total + ",\"rows\":" + listjson + "}";
		return json;
	}
}
