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
		
		//调用service层中的login方法
		User user = service.login(number);
		//判断：三种情况：没这个用户，密码错误，登陆成功
		String loginInfo = "用户不存在";
		if(user!=null) {
			//System.out.println("用户不存在");
			if(password.equals(user.getPassword())) {
				System.out.println("登陆成功");
				session.setAttribute("user", user);
				//登陆成功，将用户信息保存到session域中，供气压页面访问,main
				return "main";
			}else {
				loginInfo = "密码错误";
				System.out.println("密码错误");
			}
		}
		model.addAttribute("loginInfo",loginInfo);
		return "index";
		
		
		//model.addAttribute("loginMS", "我创建的第一个ssm项目");
		//System.out.println("123456");
		//return "index";
	}
	
	//添加用户
	@RequestMapping(value="/addUser")
	public String addUser(User user, Model model) {
		System.out.println("========>"+user);
		int in = service.addUser(user);
		String addInfo = "0";
		if(in>0) {
			System.out.println("添加成功");
			addInfo = "1";
		}
		//将添加的结果用model放到request域中
		model.addAttribute("addInfo",addInfo);
		
		return "addUsers";
	}

	//删除数据
	@RequestMapping(value="/deleteUser",produces=("application/text;charset=utf-8"))
	@ResponseBody
	public String deleteUser(String number) {
		System.out.println("要输出的number:"+number);
		
		//条用service完成删除
		int in = service.deleteUser(number);
		String reInfo = "删除失败";
		if(in>0) {
			
			reInfo = "删除成功";
			System.out.println("删除成功");
		}
		return reInfo;
	}
	
	//修改数据
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(User user) {
		System.out.println("=========="+user);
		
		//调用service层来完成修改操作
		int in = service.updateUser(user);
		if(in>0) {
			System.out.println("修改成功");
			return "1";
		}
		
		return "0";
	}

	//分页
	@RequestMapping(value="/findUsers", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findUsers(int page, int rows) {

		System.out.println("page==="+page+";rows===" + rows);
		// 使用分页插件完成分页：page-->当前页，rows--->查询的条
		PageHelper.startPage(page, rows);

		// 查询所有数据
		List<User> list = service.findUsers();

		// 将得到的数据封装成json数据
		String listjson = JSON.toJSONString(list);
		PageInfo info = new PageInfo<>(list);
		long total = info.getTotal();
		System.out.println("总记录数:"+total);

		list.forEach(li -> System.out.println(li));

		// 构建返回给前端的json数据

		String json = "{\"total\":" + total + ",\"rows\":" + listjson + "}";
		return json;
	}
}
