package com.zzupms.dao;

import java.util.List;

import com.zzupms.entity.Recruit;

public interface RecruitDao {
	public int insertRecruit(Recruit recruit);
	public List<Recruit> queryAllRecruit();
	public Recruit queryRecruitById(Integer id);
	public int gotoFace(Integer id);
	public int delete(Integer id);
}
