package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.ScheduleFile;



public interface ScheduleFileDao {

	public List<ScheduleFile> getscheduleFiles(String ScheduleCode);
	public int insert(ScheduleFile file);
	
}
