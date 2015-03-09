package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.FreeFile;

public interface FreeFileDao {
	public List<FreeFile> getFreeFiles(String FreeCode);
	public int insert(FreeFile file);
}
