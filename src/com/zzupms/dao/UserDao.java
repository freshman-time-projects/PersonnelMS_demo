package com.zzupms.dao;

import java.util.List;

import com.zzupms.entity.User;

public interface UserDao {
	public void addUser(User user);
	public User queryUser(String username); 
	public List<User> queryAll();
	public int removeUser(String username);
	public int modifyUser(User user);
}
