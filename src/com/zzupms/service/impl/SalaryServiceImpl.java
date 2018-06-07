package com.zzupms.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzupms.dao.SalaryDao;
import com.zzupms.entity.Salary;
import com.zzupms.service.SalaryService;
import com.zzupms.util.MyBatisUtil;

public class SalaryServiceImpl implements SalaryService{

	public int addSalary(Salary salary) {
		int flag=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			SalaryDao dao = session.getMapper(SalaryDao.class);
			flag = dao.insertSalary(salary);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Salary> showAllSalary(String k) {
		SqlSession session = null;
		List<Salary>salarys = null;
		try {
			session = MyBatisUtil.openSession();
			SalaryDao dao = session.getMapper(SalaryDao.class);
			if(k.equals("all")){
				salarys = dao.queryAllSalarys();
				session.commit();
				}
			if(k.equals("salarydesc")){
				salarys = dao.queryAllSalarysBySalaryDesc();
				session.commit();
				}
			if(k.equals("bonusdesc")){
				salarys = dao.queryAllSalarysByBonusDesc();
				session.commit();
				}
			
			if(k.equals("finedesc")){
				salarys = dao.queryAllSalarysByFineDesc();
				session.commit();
				}
			if(k.equals("finaldesc")){
				salarys = dao.queryAllSalarysByFinalDesc();
				session.commit();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salarys;
	}
	public int updateBonus(int id,int bonus) {
		SqlSession session = null;
		Salary salary = new Salary();
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			SalaryDao dao = session.getMapper(SalaryDao.class);
			salary.setId(id);
			salary.setBonus(bonus);
			flag = dao.updateBonus(salary);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException("未知错误");
		}finally{
			session.close();
		}
		return flag;
	}
	@Override
	public int updateFine(int id,int fine) {
		SqlSession session = null;
		Salary salary = new Salary();
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			SalaryDao dao = session.getMapper(SalaryDao.class);
			salary.setId(id);
			salary.setFine(fine);
			flag = dao.updateFine(salary);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException("未知错误");
		}finally{
			session.close();
		}
		return flag;
	}
	public int uplevel(int id, int level,int salary) {
		SqlSession session = null;
		Salary Salary = new Salary();
		int flag=0;
		try {
			session = MyBatisUtil.openSession();
			SalaryDao dao = session.getMapper(SalaryDao.class);
			Salary.setId(id);
			Salary.setLevel(level);
			Salary.setSalary(salary);
			flag = dao.uplevel(Salary);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException("未知错误");
		}finally{
			session.close();
		}
		return flag;
	}
	@Override
	public int removeSalary(int id) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			SalaryDao dao = session.getMapper(SalaryDao.class);
			flag = dao.removeSalary(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
