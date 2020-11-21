package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.User;

@Service
public interface UserService {
	
	//1.��½
	User login(String number);
	
	//2.ע��
	int addUser(User user);
	
	List<User> searchUsers();
	//List<User> findNotices();
	int deleteUser(String number);
	
	//�޸�����
	int updateUser(User user);
	//��ѯ��������
	List<User> findUsers();
}
