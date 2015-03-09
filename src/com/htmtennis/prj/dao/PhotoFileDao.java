package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.PhotoFile;

public interface PhotoFileDao {

	public List<PhotoFile> getPhotoFiles(String code);
	public int insert(PhotoFile file);
}
