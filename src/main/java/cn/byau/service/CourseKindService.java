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
	/**
     *   这个方法中用到了分页插件pagehelper
     *   很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum 开始页数
     * @param pageSize 每页显示的数据条数
     
     * @return
     */
	public PageInfo<CourseKind> listByPage(Integer pageNum, Integer pageSize) {
		 //将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<CourseKind> list = courseKindDao.list();
		PageInfo<CourseKind> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
    
    
    
}
