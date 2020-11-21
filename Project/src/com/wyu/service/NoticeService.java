package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.Notice;
@Service
public interface NoticeService {
	
	//лМ╪спбне
	int insertNotice(Notice notice);

	List<Notice> findNotices();
}
