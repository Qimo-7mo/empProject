package com.wyu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSessionFactory sqlSession;
	
	//��̬�������ص�������Ĵ����������ʱִ�У���ִ��һ��
	static {
		// ��ȡmybatis�ĺ��������ļ�
		String configXml = "mybatis-config.xml";
		InputStream inputStream;
		try{
			inputStream= Resources.getResourceAsStream(configXml);
			// ����SqlSessionFactory
			 sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//��дһ����������ֱ�ӻ��SqlSession����
	public static SqlSession  getSession() {
		return sqlSession.openSession();
	}
	
	//��װһ���������Թر���Դ
	public static void close(SqlSession session) {
		if(session!=null) {
			session.close();
		}
	}

}
