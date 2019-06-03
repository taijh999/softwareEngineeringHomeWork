package cn.byau.service;

import cn.byau.dao.CourseKindMapper;
import cn.byau.pojo.Course;
import cn.byau.pojo.CourseKind;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tjh on 2017/5/13.
 */
@Service("courseKindService")
public class CourseKindService {

    @Autowired
    private CourseKindMapper courseKindDao;

    public List<CourseKind> list() {
        return courseKindDao.list();
    }
    public CourseKind getByKindId(String kindId) {
        return courseKindDao.getByKindId(kindId);
    }
    
    public void save(CourseKind courseKind) {
    	courseKindDao.save(courseKind);
	}

	

	public void update(CourseKind courseKind) {
		courseKindDao.update(courseKind);
	}

	

	public void delete(String kindId) {
		courseKindDao.delete(kindId);
	}
	
	public PageInfo<CourseKind> listByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<CourseKind> list = courseKindDao.list();
		PageInfo<CourseKind> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
    
    
    
}
