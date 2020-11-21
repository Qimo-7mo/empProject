package com.wyu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.mapper.UserMapper;
import com.wyu.pojo.User;
import com.wyu.pojo.UserExample;
import com.wyu.util.MybatisUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User login(String number) {
		// TODO Auto-generated method stub
		
		return mapper.selectByPrimaryKey(number);
	}

	//����û�
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return mapper.insert(user);
	}

	@Override
	public List<User> searchUsers() {
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UserExample example = new UserExample();
		
		List<User> list = mapper.selectByExample(example);
		list.forEach(li->System.out.println(li));
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(String number) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(number);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(user);//�о��޸ģ�û�о�ԭ�ⲻ��
	}

	//��ѯ���е�����
	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		List<User> list = mapper.selectByExample(new UserExample());
		list.forEach(li->System.out.println("=================>"+li));
		return list;
	}



}
