package com.zzupms.service;

import java.util.List;

import com.zzupms.entity.Recruit;

public interface RecruitService {
	public List<Recruit> queryAllRecruit();
	public Recruit queryRecruitById(Integer id);
	public int insertRecruit(Recruit recruit);
	public int gotoFace(Integer id);
	public int delete(Integer id);
}
