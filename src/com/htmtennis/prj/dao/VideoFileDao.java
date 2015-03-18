package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.VideoFile;

public interface VideoFileDao {

	public List<VideoFile> getVideoFiles(String code);
	public int insert(VideoFile file);
}
