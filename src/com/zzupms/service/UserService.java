package com.zzupms.service;

import java.util.List;

import com.zzupms.entity.User;

public interface UserService {
	public int login(String username,String password);
	public boolean register(Integer id,String username,String password,String password2, String qq);
	public int removeUser(String username);
	public int modifyUser(String username,String password);
	public List<User> queryAll();
}	
