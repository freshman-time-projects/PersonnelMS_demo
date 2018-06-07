package com.zzupms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzupms.dao.UserDao;
import com.zzupms.entity.User;
import com.zzupms.service.UserService;
import com.zzupms.util.MyBatisUtil;

public class UserServiceImpl implements UserService{

	/**
	 * 判断username和password 是否登录
	 */
	@Override
	public List<User> queryAll(){
		SqlSession session = null;
		List<User> user = null;
		try {
			session = MyBatisUtil.openSession();
			UserDao dao = session.getMapper(UserDao.class);
			user = dao.queryAll();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public int login(String username, String password) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			UserDao userdao = session.getMapper(UserDao.class);
			//调用dao查询username的user对象
			User user = userdao.queryUser(username);
			if(user == null || !user.getPassword().equals(password)){
				throw new RuntimeException("用户名和密码不正确");
			}
			else 
				flag++;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return flag;
		
	}

	@Override
	public boolean register(Integer id,String username, String password,String password2,String qq) {
		SqlSession session = null;
		try {
			if(!password.equals(password2)){
				throw new RuntimeException("两次密码不一致");
			}
			session = MyBatisUtil.openSession();
			UserDao userdao = session.getMapper(UserDao.class);
			User user = userdao.queryUser(username);
			if(user != null){
				throw new RuntimeException("用户名已存在");
			}else{
				user = new User();
				user.setId(0);
				user.setPassword(password);
				user.setUsername(username);
				user.setQq(qq);
				userdao.addUser(user);
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return true;
	}

	@Override
	public int removeUser(String username) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			UserDao dao = session.getMapper(UserDao.class);
			flag = dao.removeUser(username);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int modifyUser(String username,String password) {
		SqlSession session = null;
		User user = new User();
		int flag = 0;
		try {
			session = MyBatisUtil.openSession();
			UserDao dao = session.getMapper(UserDao.class);
			user.setUsername(username);
			user.setPassword(password);
			flag = dao.modifyUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
