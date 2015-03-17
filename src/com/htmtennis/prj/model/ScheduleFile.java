package com.htmtennis.prj.model;

import java.util.Date;

public class ScheduleFile {

	private String schedulename;
	private String schedulecode;
	private Date regdate;
	private String schedulesrc;
	private String schedulevent;
	
	
	public String getSchedulevent() {
		return schedulevent;
	}
	public void setSchedulevent(String schedulevent) {
		this.schedulevent = schedulevent;
	}
	public String getSchedulename() {
		return schedulename;
	}
	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}
	public String getSchedulecode() {
		return schedulecode;
	}
	public void setSchedulecode(String schedulecode) {
		this.schedulecode = schedulecode;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getSchedulesrc() {
		return schedulesrc;
	}
	public void setSchedulesrc(String schedulesrc) {
		this.schedulesrc = schedulesrc;
	}
	
	
	
	
}
