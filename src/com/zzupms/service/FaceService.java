package com.zzupms.service;

import java.util.List;

import com.zzupms.entity.Face;

public interface FaceService {
	public List<Face> queryAllFace();
	public int addFace(Face face);
	public int removeFace(int id);
}
