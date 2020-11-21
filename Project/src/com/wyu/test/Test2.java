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

	//���������������в�Ϊ�յ�ֵ���������ݿ�
	public static void updateExample(EmployeeMapper employeeMapper) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("����");
		Employee employee = new Employee();
		employee.setAddress("���");
		employee.setParty("Ⱥ��");
		int in = employeeMapper.updateByExampleSelective(employee, example);
		if(in!=0) {
			System.out.println("�ɹ�����"+in+"������");
		}else {
			System.out.println("����ʧ��");
		}
	}

	//���������������������ֶε�ֵ���������ݿ�
	public static void update(EmployeeMapper employeeMapper) {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setDeptId(2);
		employee.setJobId(3);
		employee.setName("���");
		employee.setCardId("11111");
		employee.setAddress("����ϲ��");
		employee.setPostCode("11111");
		employee.setTel("11111");
		employee.setPhone("11111");
		employee.setEmail("1111@163.com");
		employee.setSex("Ů");
		employee.setParty("��Ա");
		employee.setBirthday(new Date());
		employee.setRace("׳��");
		employee.setEducation("˶ʿ");
		employee.setSpeciality("����");
		employee.setHobby("ѧϰ");
		employee.setCreateDate(new Date());
		int in = employeeMapper.updateByPrimaryKey(employee);
		if(in!=0) {
			System.out.println("���³ɹ�"+in+"������");
		}else {
			System.out.println("����ʧ��");
		}
	}

	//ɾ�����������ļ�¼
	public static void delectExample(EmployeeMapper employeeMapper) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//criteria.andNameLike("%��%");
		criteria.andCardIdNotEqualTo("777777");
		int in = employeeMapper.deleteByExample(example);
		if(in!=0) {
			System.out.println("�ɹ�ɾ����ɾ����"+in+"������");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}

	//��������ɾ��
	public static void delect(EmployeeMapper employeeMapper) {
		int re = employeeMapper.deleteByPrimaryKey(1);
		if(re!=0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}

	//�������Ϊ�յ��ֶ�
	public static void insertSelective(EmployeeMapper employeeMapper) {
		Employee employee = new Employee();
		employee.setDeptId(2);
		employee.setJobId(3);
		employee.setName("�ŷ�");
		employee.setCardId("98547");
		employee.setAddress("����");
		employee.setPostCode("523");
		employee.setTel("125656");
		employee.setPhone("1112211");
		employee.setEmail("4554@163.com");
		employee.setSex("��");
		employee.setParty("��Ա");
		employee.setBirthday(new Date());
		employee.setRace("׳��");
		employee.setEducation("˶ʿ");
		employee.setSpeciality("����");
		employee.setHobby("ѧϰ");
		employee.setCreateDate(new Date());

		int in = employeeMapper.insertSelective(employee);
		if(in!=0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
	}

	//������������ֶ�
	public static void insert(EmployeeMapper employeeMapper) {
		Employee employee = new Employee();
		employee.setDeptId(1);
		employee.setJobId(2);
		employee.setName("����");
		employee.setCardId("154647");
		employee.setAddress("����");
		employee.setPostCode("123");
		employee.setTel("123456");
		employee.setPhone("1111111");
		employee.setEmail("45621@qq.com");
		employee.setSex("��");
		employee.setParty("������Ա");
		employee.setBirthday(new Date());
		employee.setRace("׳��");
		employee.setEducation("����");
		employee.setSpeciality("ʮ�˰�����");
		employee.setHobby("ѧϰ");
		employee.setCreateDate(new Date());

		int in = employeeMapper.insert(employee);
		if(in!=0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
	}

	//nameģ����ѯ
	public static void selectExample(EmployeeMapper employeeMapper) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%��%");
		List<Employee> list = employeeMapper.selectByExample(example);
		list.forEach(li->System.out.println(li));
	}

	//����������ѯ
	public static void selectOne(EmployeeMapper employeeMapper) {
		Employee employee = employeeMapper.selectByPrimaryKey(1);
		System.out.println(employee);
	}

	//���session�ķ���
	public static SqlSession getSession()  {
		try {
		// ��ȡmybatis�ĺ��������ļ�
		String configXml = "mybatis-config.xml";

		InputStream inputStream = Resources.getResourceAsStream(configXml);

		// ����sqlSessionFactory
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(inputStream);

		// ʹ��sqlSessionFactory ����sqlSession
		SqlSession session = sqlSession.openSession(true);
		return session;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
