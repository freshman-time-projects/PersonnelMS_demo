package com.zzupms.service;

import java.util.List;

import com.zzupms.entity.Person;


public interface PersonService {
	public int addPerson(Person person);
	
	public List<Person> showAllPerson();
	
	public List<Person> showPersonById(Integer id);
	
	public List<Person> searchPerson(String name);
	
	public int removePerson(Integer id);
	
	public int updatePerson(Person person);
}
