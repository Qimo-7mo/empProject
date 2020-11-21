package com.wyu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.wyu.mapper.UserMapper;
import com.wyu.pojo.User;
import com.wyu.pojo.UserExample;
import com.wyu.util.MybatisUtil;

public class jsonTest2 {
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UserExample example = new UserExample();
		List<User> list = mapper.selectByExample(example);
	
		list.forEach(li->System.out.println(li));
		
		String jsonString = JSON.toJSONString(list);
		System.out.println("==============================");
		System.out.println(jsonString);
	}
}
