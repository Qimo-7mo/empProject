package com.wyu.test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wyu.mapper.EmployeeMapper;
import com.wyu.pojo.Employee;
import com.wyu.pojo.EmployeeExample;
import com.wyu.pojo.User;
import com.wyu.pojo.UserExample;
import com.wyu.pojo.EmployeeExample.Criteria;

public class Test2 {
	public static void main(String[] args) {
			SqlSession session = getSession();
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			delectExample(employeeMapper);
			//insertSelective(employeeMapper);
			
	}

	//根据主键将对象中不为空的值更新至数据库
	public static void updateExample(EmployeeMapper employeeMapper) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("关羽");
		Employee employee = new Employee();
		employee.setAddress("蜀国");
		employee.setParty("群众");
		int in = employeeMapper.updateByExampleSelective(employee, example);
		if(in!=0) {
			System.out.println("成功更新"+in+"条数据");
		}else {
			System.out.println("更新失败");
		}
	}

	//根据主键将对象中所有字段的值更新至数据库
	public static void update(EmployeeMapper employeeMapper) {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setDeptId(2);
		employee.setJobId(3);
		employee.setName("红儿");
		employee.setCardId("11111");
		employee.setAddress("欢天喜地");
		employee.setPostCode("11111");
		employee.setTel("11111");
		employee.setPhone("11111");
		employee.setEmail("1111@163.com");
		employee.setSex("女");
		employee.setParty("党员");
		employee.setBirthday(new Date());
		employee.setRace("壮族");
		employee.setEducation("硕士");
		employee.setSpeciality("政治");
		employee.setHobby("学习");
		employee.setCreateDate(new Date());
		int in = employeeMapper.updateByPrimaryKey(employee);
		if(in!=0) {
			System.out.println("更新成功"+in+"条数据");
		}else {
			System.out.println("更新失败");
		}
	}

	//删除符合条件的记录
	public static void delectExample(EmployeeMapper employeeMapper) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//criteria.andNameLike("%张%");
		criteria.andCardIdNotEqualTo("777777");
		int in = employeeMapper.deleteByExample(example);
		if(in!=0) {
			System.out.println("成功删除，删除了"+in+"条数据");
		}else {
			System.out.println("删除失败");
		}
	}

	//根据主键删除
	public static void delect(EmployeeMapper employeeMapper) {
		int re = employeeMapper.deleteByPrimaryKey(1);
		if(re!=0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}

	//插入对象不为空的字段
	public static void insertSelective(EmployeeMapper employeeMapper) {
		Employee employee = new Employee();
		employee.setDeptId(2);
		employee.setJobId(3);
		employee.setName("张飞");
		employee.setCardId("98547");
		employee.setAddress("三国");
		employee.setPostCode("523");
		employee.setTel("125656");
		employee.setPhone("1112211");
		employee.setEmail("4554@163.com");
		employee.setSex("男");
		employee.setParty("党员");
		employee.setBirthday(new Date());
		employee.setRace("壮族");
		employee.setEducation("硕士");
		employee.setSpeciality("政治");
		employee.setHobby("学习");
		employee.setCreateDate(new Date());

		int in = employeeMapper.insertSelective(employee);
		if(in!=0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}

	//插入对象所有字段
	public static void insert(EmployeeMapper employeeMapper) {
		Employee employee = new Employee();
		employee.setDeptId(1);
		employee.setJobId(2);
		employee.setName("关羽");
		employee.setCardId("154647");
		employee.setAddress("三国");
		employee.setPostCode("123");
		employee.setTel("123456");
		employee.setPhone("1111111");
		employee.setEmail("45621@qq.com");
		employee.setSex("男");
		employee.setParty("共青团员");
		employee.setBirthday(new Date());
		employee.setRace("壮族");
		employee.setEducation("高中");
		employee.setSpeciality("十八班武艺");
		employee.setHobby("学习");
		employee.setCreateDate(new Date());

		int in = employeeMapper.insert(employee);
		if(in!=0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}

	//name模糊查询
	public static void selectExample(EmployeeMapper employeeMapper) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%张%");
		List<Employee> list = employeeMapper.selectByExample(example);
		list.forEach(li->System.out.println(li));
	}

	//根据主键查询
	public static void selectOne(EmployeeMapper employeeMapper) {
		Employee employee = employeeMapper.selectByPrimaryKey(1);
		System.out.println(employee);
	}

	//获得session的方法
	public static SqlSession getSession()  {
		try {
		// 读取mybatis的核心配置文件
		String configXml = "mybatis-config.xml";

		InputStream inputStream = Resources.getResourceAsStream(configXml);

		// 创建sqlSessionFactory
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(inputStream);

		// 使用sqlSessionFactory 创建sqlSession
		SqlSession session = sqlSession.openSession(true);
		return session;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
