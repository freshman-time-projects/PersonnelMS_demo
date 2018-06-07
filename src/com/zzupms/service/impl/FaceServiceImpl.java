package com.zzupms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzupms.dao.FaceDao;
import com.zzupms.entity.Face;
import com.zzupms.service.FaceService;
import com.zzupms.util.MyBatisUtil;

public class FaceServiceImpl implements FaceService{
	@Override
	public List<Face> queryAllFace() {
		SqlSession session = null;
		List<Face> face = null;
		try {
			session=MyBatisUtil.openSession();
			FaceDao dao = session.getMapper(FaceDao.class);
			face = dao.queryAllFace();
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException("出错啦！！！");
		}finally{
			session.close();
		}
		return face;
	}

	@Override
	public int addFace(Face face) {
		int flag = 0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			FaceDao dao = session.getMapper(FaceDao.class);
			flag = dao.addFace(face);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			session.close();
		}
		return flag;
	}

	@Override
	public int removeFace(int id) {
		int flag = 0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			FaceDao dao = session.getMapper(FaceDao.class);
			flag = dao.removeFace(id);
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
