package com.wyu.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyu.mapper.NoticeMapper;
import com.wyu.pojo.Notice;
import com.wyu.pojo.NoticeExample;
import com.wyu.util.MybatisUtil;

public class NoticeServiceImpl implements NoticeService {

	@Autowired
	//private NoticeMapper mapper;
	
	//Ìí¼Ó¹«¸æ
	@Override
	public int insertNotice(Notice notice) {
		SqlSession session = MybatisUtil.getSession();
		NoticeMapper mapper = session.getMapper(NoticeMapper.class);
		
		return mapper.insert(notice);
	}

	@Override
	public List<Notice> findNotices() {
		SqlSession session = MybatisUtil.getSession();
		NoticeMapper mapper = session.getMapper(NoticeMapper.class);
		
		NoticeExample example = new NoticeExample();
		List<Notice> list = mapper.selectByExampleWithBLOBs(example);
		list.forEach(li->System.out.println(li));
		return null;
	}
}
