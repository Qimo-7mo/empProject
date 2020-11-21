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

	//���������������в�Ϊ�յ�ֵ���������ݿ�
	public static void updateByPrimaryKeySelective(UserMapper userMapper) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo("����");
		User user = new User();
		user.setPassword("000000");
		int in = userMapper.updateByExampleSelective(user, example);
		if(in!=0) {
			System.out.println("�ɹ�����"+in+"������");
		}else {
			System.out.println("����ʧ��");
		}
	}

	//���������������������ֶε�ֵ���������ݿ�
	public static void update(UserMapper userMapper) {
		User user = new User();
		user.setNumber("071940309");
		user.setUsername("����");
		user.setPassword("66666");
		user.setCreatedate(new Date());
		user.setPhone("66666");
		user.setRoleId(1);
		int in = userMapper.updateByPrimaryKey(user);
		if(in!=0) {
			System.out.println("�ɹ�����"+in+"������");
		}else {
			System.out.println("����ʧ��");
		}
	}

	//�������Ϊ�յ��ֶ�
	public static void insert(UserMapper userMapper) {
		User user = new User();
		user.setNumber(new SimpleDateFormat("MMDDmmss").format(new Date()));
		user.setPassword("00000");
		user.setRoleId(1);
		user.setPhone("457456491");
		user.setCreatedate(new Date());
		user.setUsername("����");
		
		int in = userMapper.insertSelective(user);
		if(in!=0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
	}

	//ɾ�����������ļ�¼
	public static void delectAll(UserMapper userMapper) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordLike("%a%");
		int in = userMapper.deleteByExample(example);
		if(in!=0) {
			System.out.println("�ɹ�ɾ����ɾ����"+in+"������");
		}
	}

	//��������ɾ��
	public static void delectOne(UserMapper userMapper) {
		int re = userMapper.deleteByPrimaryKey("012");
		if(re!=0) {
			System.out.println("ɾ���ɹ�");
		}
	}

	//ģ����ѯ
	public static void selectByEx(UserMapper userMapper) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%С%");
		List<User> list = userMapper.selectByExample(example);
		list.forEach(li->System.out.println(li));
	}

	//����������ѯ
	public static void selectOne(UserMapper userMapper) {
		User user = userMapper.selectByPrimaryKey("3217002559");
		System.out.println(user);
	}

	

}
