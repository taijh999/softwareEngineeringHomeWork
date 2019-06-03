package cn.byau.dao;

import java.util.List;

import cn.byau.pojo.Course;
import cn.byau.pojo.CourseKind;

public interface CourseKindMapper {
	List<CourseKind> list();

	CourseKind getByKindId(String kindId);
	int delete(String kindId);

    int save(CourseKind record);

    //int insertSelective(CourseKind record);

    

   // int updateByPrimaryKeySelective(CourseKind record);

    int update(CourseKind record);
	
	

}