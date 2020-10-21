package com.mizhi.yxd.service;

import java.util.List;
import java.util.Map;

import com.mizhi.yxd.entity.Scores;

public interface GcCourseService {
	public List<Scores>findScores(String coursename, String type, String gcg, String gcc, int start, int pagesize );
	public List<Scores>findAllScores(String coursename,String type,String gcg,String gcc);
	public List<Scores>compClaScores(String coursename,String gcg);
	public int updateScores(Map map);
	public List<Scores> findPersonScore(String coursename,String num);
}
