package com.zzupms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzupms.dao.RecruitDao;
import com.zzupms.entity.Recruit;
import com.zzupms.service.RecruitService;
import com.zzupms.util.MyBatisUtil;

public class RecruitServiceImpl implements RecruitService{
	@Override
	public int insertRecruit(Recruit recruit) {
		int flag = 0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			RecruitDao dao = session.getMapper(RecruitDao.class);
			flag = dao.insertRecruit(recruit);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Recruit> queryAllRecruit() {
		SqlSession session = null;
		List<Recruit>recruit = null;
		try {
			session = MyBatisUtil.openSession();
			RecruitDao dao = session.getMapper(RecruitDao.class);
			recruit = dao.queryAllRecruit();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return recruit;
	}
	@Override
	public Recruit queryRecruitById(Integer id) {
		SqlSession session = null;
		Recruit recruit = null;
		try {
			session = MyBatisUtil.openSession();
			RecruitDao dao = session.getMapper(RecruitDao.class);
			recruit = dao.queryRecruitById(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return recruit;
	}
	
	@Override
	public int gotoFace(Integer id) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			RecruitDao dao = session.getMapper(RecruitDao.class);
			flag = dao.gotoFace(id);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException("出错啦！！！");
		}
		return flag;
	}
	@Override
	public int delete(Integer id) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			RecruitDao dao = session.getMapper(RecruitDao.class);
			flag = dao.delete(id);
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
