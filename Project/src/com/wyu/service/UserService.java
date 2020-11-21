package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.User;

@Service
public interface UserService {
	
	//1.登陆
	User login(String number);
	
	//2.注册
	int addUser(User user);
	
	List<User> searchUsers();
	//List<User> findNotices();
	int deleteUser(String number);
	
	//修改数据
	int updateUser(User user);
	//查询所有数据
	List<User> findUsers();
}
