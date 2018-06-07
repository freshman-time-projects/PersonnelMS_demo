package com.zzupms.dao;

import java.util.List;

import com.zzupms.entity.Salary;

public interface SalaryDao {
	public int insertSalary(Salary salary);
	public List<Salary> queryAllSalarys();
	public List<Salary> queryAllSalarysBySalaryDesc();
	public List<Salary> queryAllSalarysByBonusDesc();
	public List<Salary> queryAllSalarysByFineDesc();
	public List<Salary> queryAllSalarysByFinalDesc();
	public int updateBonus(Salary salary);
	public int updateFine(Salary salary);
	public int uplevel(Salary salary);
	public int removeSalary(int id);
	
}
