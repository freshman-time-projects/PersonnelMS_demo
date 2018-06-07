package com.zzupms.dao;

import java.util.List;

import com.zzupms.entity.Person;
import com.zzupms.entity.User;


public interface PersonDao {
	public int insertPerson(Person p);
	public List<Person> queryAllPersons();
	public List<Person> queryPersonsById(Integer id);
	public List<Person> searchPerson(String name);
	public int removePerson(Integer id);
	public int updatePerson(Person person);
}
