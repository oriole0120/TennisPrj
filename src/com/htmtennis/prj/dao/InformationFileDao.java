package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.InformationFile;

public interface InformationFileDao {
	public List<InformationFile> getInformationFiles(String InformationCode);
	public int insert(InformationFile file);
}
