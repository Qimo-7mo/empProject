package com.wyu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.wyu.mapper.NoticeMapper;
import com.wyu.pojo.Notice;
import com.wyu.pojo.NoticeExample;
import com.wyu.util.MybatisUtil;

public class jsonTest {
	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSession();
		NoticeMapper mapper = session.getMapper(NoticeMapper.class);
		
		NoticeExample example = new NoticeExample();
		List<Notice> list = mapper.selectByExampleWithBLOBs(example);
		list.forEach(li->System.out.println(li));
		
		String jsonString = JSON.toJSONString(list);
		System.out.println("==============================");
		System.out.println(jsonString);
	}
}
