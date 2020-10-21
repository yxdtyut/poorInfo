package com.mizhi.yxd.mapper;

import java.util.List;
import java.util.Map;

import com.mizhi.yxd.entity.Scores;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GcCourseMapper {
	public List<Scores>findScores(String coursename, String type, String gcg, String gcc, int start, int pagesize );
	public List<Scores>findAllScores(String coursename,String type,String gcg,String gcc);
	public List<Scores>compClaScores(String coursename,String gcg);
	public int updateScores(Map map);
	public List<Scores> findPersonScore(String coursename,String num);
}
