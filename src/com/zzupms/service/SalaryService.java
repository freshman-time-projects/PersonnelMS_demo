package com.zzupms.service;

import java.util.List;

import com.zzupms.entity.Salary;


public interface SalaryService {
	public int addSalary(Salary salary);
	
	public List<Salary> showAllSalary(String k);		
	
	public int updateBonus(int id,int bonus);
	
	public int updateFine(int id,int fine);
	
	public int uplevel(int id,int level,int salary);
	
	public int removeSalary(int id);
}

