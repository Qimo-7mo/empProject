package com.wyu.test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wyu.mapper.UserMapper;
import com.wyu.pojo.User;
import com.wyu.pojo.UserExample;
import com.wyu.pojo.UserExample.Criteria;
import com.wyu.util.MybatisUtil;

public class Test1 {
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		selectOne(userMapper);
	}

	//根据主键将对象中不为空的值更新至数据库
	public static void updateByPrimaryKeySelective(UserMapper userMapper) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo("李四");
		User user = new User();
		user.setPassword("000000");
		int in = userMapper.updateByExampleSelective(user, example);
		if(in!=0) {
			System.out.println("成功更新"+in+"条数据");
		}else {
			System.out.println("更新失败");
		}
	}

	//根据主键将对象中所有字段的值更新至数据库
	public static void update(UserMapper userMapper) {
		User user = new User();
		user.setNumber("071940309");
		user.setUsername("李四");
		user.setPassword("66666");
		user.setCreatedate(new Date());
		user.setPhone("66666");
		user.setRoleId(1);
		int in = userMapper.updateByPrimaryKey(user);
		if(in!=0) {
			System.out.println("成功更新"+in+"条数据");
		}else {
			System.out.println("更新失败");
		}
	}

	//插入对象不为空的字段
	public static void insert(UserMapper userMapper) {
		User user = new User();
		user.setNumber(new SimpleDateFormat("MMDDmmss").format(new Date()));
		user.setPassword("00000");
		user.setRoleId(1);
		user.setPhone("457456491");
		user.setCreatedate(new Date());
		user.setUsername("李四");
		
		int in = userMapper.insertSelective(user);
		if(in!=0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}

	//删除符合条件的记录
	public static void delectAll(UserMapper userMapper) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordLike("%a%");
		int in = userMapper.deleteByExample(example);
		if(in!=0) {
			System.out.println("成功删除，删除了"+in+"条数据");
		}
	}

	//根据主键删除
	public static void delectOne(UserMapper userMapper) {
		int re = userMapper.deleteByPrimaryKey("012");
		if(re!=0) {
			System.out.println("删除成功");
		}
	}

	//模糊查询
	public static void selectByEx(UserMapper userMapper) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%小%");
		List<User> list = userMapper.selectByExample(example);
		list.forEach(li->System.out.println(li));
	}

	//根据主键查询
	public static void selectOne(UserMapper userMapper) {
		User user = userMapper.selectByPrimaryKey("3217002559");
		System.out.println(user);
	}

	

}
