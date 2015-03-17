package com.htmtennis.prj.dao;




import java.util.List;

import com.htmtennis.prj.model.Schedule;

public interface ScheduleDao {

    public Schedule getSchedule(String code);
   
    public Schedule preSchedule(String curCode);
    public Schedule nextSchedule(String curCode);
    
    public List<Schedule> getSchedules(int page, String query, String field);
    public List<Schedule> getSchedules(int page, String query);
    public List<Schedule> getSchedules(int page);
	
	public int insert(Schedule schedule);
	public int update(Schedule schedule);
	public int delete(String code);
	
	public int getSize(String query, String field);
	public int getSize(String query);
	public String lastCode();
}
