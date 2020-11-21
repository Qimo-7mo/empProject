package com.wyu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSessionFactory sqlSession;
	
	//静态代码块的特点是里面的代码在类加载时执行，且执行一次
	static {
		// 读取mybatis的核心配置文件
		String configXml = "mybatis-config.xml";
		InputStream inputStream;
		try{
			inputStream= Resources.getResourceAsStream(configXml);
			// 创建SqlSessionFactory
			 sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//编写一个方法可以直接获得SqlSession对象
	public static SqlSession  getSession() {
		return sqlSession.openSession();
	}
	
	//封装一个方法可以关闭资源
	public static void close(SqlSession session) {
		if(session!=null) {
			session.close();
		}
	}

}
