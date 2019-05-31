package cn.byau.dao;

import java.util.List;

import cn.byau.pojo.Course;
import cn.byau.pojo.CourseKind;

public interface CourseKindMapper {
	List<CourseKind> list();

	CourseKind getByKindId(String kindId);
	
	
	

}