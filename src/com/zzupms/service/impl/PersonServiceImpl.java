package com.zzupms.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzupms.dao.PersonDao;
import com.zzupms.entity.Person;
import com.zzupms.service.PersonService;
import com.zzupms.util.MyBatisUtil;

public class PersonServiceImpl implements PersonService{
	public int addPerson(Person person) {
		int flag=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			PersonDao dao = session.getMapper(PersonDao.class);
			flag = dao.insertPerson(person);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}
	public List<Person> showAllPerson() {
		SqlSession session = null;
		List<Person>persons = null;
		try {
			session = MyBatisUtil.openSession();
			PersonDao dao = session.getMapper(PersonDao.class);
			persons = dao.queryAllPersons();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}
	public List<Person> showPersonById(Integer id) {
		SqlSession session = null;
		List<Person> persons = null;
		try {
			session = MyBatisUtil.openSession();
			PersonDao dao = session.getMapper(PersonDao.class);
			persons = dao.queryPersonsById(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}
	public List<Person> searchPerson(String name) {
		SqlSession session = null;
		List<Person>persons = null;
		try {
			session = MyBatisUtil.openSession();
			PersonDao dao = session.getMapper(PersonDao.class);
			persons = dao.searchPerson(name);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException("something wrong!");
		}
		return persons;
	}
	public int removePerson(Integer id) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			PersonDao dao = session.getMapper(PersonDao.class);
			flag = dao.removePerson(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return flag;
	}
	public int updatePerson(Person person) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			PersonDao dao = session.getMapper(PersonDao.class);
			flag = dao.updatePerson(person);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return flag;
	}
}
