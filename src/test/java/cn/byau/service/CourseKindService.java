package cn.byau.service;

import cn.byau.dao.CourseKindMapper;
import cn.byau.pojo.CourseKind;

import org.springframework.stereotype.Service;

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
    
    
    
}
