package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.Video;

public interface VideoDao {

	public Video getVideo(String code);
	public Video prevVideo(String curCode);
	public Video nextVideo(String curCode);
	
	public List<Video> getVideos(int page, String query, String field);
	public List<Video> getVideos(int page, String query);
	public List<Video> getVideos(int page);

	public int insert(Video video);
	public int update(Video video);
	public int delete(String code);
	
	public int getSize(String query, String field);
	public int getSize(String query);
	public String lastCode();
}
