package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.NoticeFile;



public interface NoticeFileDao {

	
	public List<NoticeFile> getnoticeFiles(String NoticCode);
	public int insert(NoticeFile file);
	
}
