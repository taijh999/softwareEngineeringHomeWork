package cn.byau.controller.user;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;

import cn.byau.entity.Course;
import cn.byau.service.CourseService;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller("userCourseController")
@RequestMapping("/user/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 跳转到分页显示页面
	 * 
	 * @param pageNum
	 *            为当前页号
	 * @param courseId
	 *            为查询的课程编号
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/listByPage")
	public String listByPage(
			@RequestParam(defaultValue="1",required=false) Integer pageNum, 
			@RequestParam(defaultValue="5",required=false) Integer pageSize,
			@RequestParam(defaultValue="",required=false)  String courseId, 
			HttpServletRequest request,
			HttpServletResponse response) {
        PageInfo<Course> pageInfo=courseService.listByPage(pageNum, pageSize, courseId);
        request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("courseId", courseId);
		//return mv;
		return "/user/course/list.jsp";

	}

	
}
