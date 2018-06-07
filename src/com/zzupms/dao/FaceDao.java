package com.zzupms.dao;

import java.util.List;

import com.zzupms.entity.Face;

public interface FaceDao {
	public List<Face> queryAllFace();
	public int addFace(Face face);
	public int removeFace(int id);
}
