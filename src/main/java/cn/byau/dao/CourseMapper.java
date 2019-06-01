package cn.byau.dao;

import java.util.List;


import cn.byau.pojo.Course;

public interface CourseMapper {
//	/**
//	 * 根据 courseId 删除一条记录
//	 * @param courseId
//	 * @return 被删除的记录个数
//	 */
//	int delete(String courseId);

	/**
	 * 添加一条记录
	 * @param course
	 * @return
	 */
	int save(Course course);

	/**
	 * 根据courseId查询一条记录
	 * @param courseId
	 * @return
	 */
	Course getById(String courseId);

	/**
	 * 修改一条记录
	 * 
	 * @param course
	 * @return
	 */
	int update(Course course);

	

	/**
	 * 根据courseId的值进行模糊查询后分页得到的记录数
	 * @param map
	 * @return
	 */
	List<Course> listByPage(String courseId);

	/**
	 * 显示所有记录
	 * 
	 * @return
	 */
	List<Course> list();

	/**
	 * 批量添加 ，从excel导入时使用
	 * @param courseList
	 * @return
	 */

	int insertBatch(List<Course> courseList);

	/**
	 * 批量删除
	 * 
	 * @param ids为主键构成的数组
	 * @return
	 */
	int deleteBatch(String[] ids);

}