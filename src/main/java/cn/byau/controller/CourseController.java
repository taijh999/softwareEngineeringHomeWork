package cn.byau.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.byau.pojo.Course;
import cn.byau.pojo.CourseKind;
import cn.byau.pojo.LogInfo;
import cn.byau.service.CourseKindService;
import cn.byau.service.CourseService;
import cn.byau.util.Result;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

	@Resource(name = "CourseService")
	private CourseService courseService;
	@Resource(name = "courseKindService")
	private CourseKindService courseKindService;

	/**
	 * 跳转到添加页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/savePage")
	public String savePage(HttpServletRequest request) {
		List<CourseKind> list = courseKindService.list();
		request.setAttribute("list", list);
		return "/WEB-INF/views/course/save.jsp";
	}

	/**
	 * 跳转到上传页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/uploadPage")
	public String upload() {
		return "/WEB-INF/views/course/upload.jsp";
	}

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
	public ModelAndView listByPage(
			@RequestParam(defaultValue="1",required=false) Integer pageNo, 
			@RequestParam(defaultValue="5",required=false) Integer pageSize,
			@RequestParam(defaultValue="",required=false)  String courseId, 
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/course/list.jsp");

		

		//List<Course> list = courseService.listByPage();
		//request.setAttribute("courseList", list);
        
		
		
		PageHelper.startPage(pageNo, pageSize);
        List<Course> courseList = courseService.listByPage(courseId);//获取所有用户信息
        PageInfo<Course> pageInfo=new PageInfo<Course>(courseList);
        request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("courseId", courseId);
		
		return mv;

	}

	/**
	 * 跳转到添加页面
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/save")
	@ResponseBody
	public Result save(Course course) {
		
		
		Result result = new Result();
		try{
			courseService.save(course);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL"); 		
		}
		return result;
	

	}


	/**
	 * 跳转到更新页面
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/updatePage")
	public ModelAndView updatePage(HttpServletRequest request) {
		String courseId = request.getParameter("courseId");
		Course course = courseService.getById(courseId);

		ModelAndView mv = new ModelAndView("/WEB-INF/views/course/update.jsp");
		mv.addObject("course", course);

		List<CourseKind> list = courseKindService.list();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Result update(Course course) {
		Result result = new Result();
		try{
			courseService.update(course);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL"); 		
		}
		return result;
		

	}
	

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public Result deleteBatch(String courseIds) {
		Result result = new Result();
		String ids[] = courseIds.split(",");
		courseService.deleteBatch(ids);
		result.setMsg("OK");
		return result;
	}

	@RequestMapping("/importFile")
	public ModelAndView importFile(@RequestParam(value = "uploadFile") MultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response) {
		String rootPath = request.getServletContext().getRealPath("/upload/");
		courseService.importFile(mFile, rootPath);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:listByPage.action");
		return mv;
	}

	@RequestMapping("/exportFile")
	
	
	public ModelAndView exportFile(HttpServletResponse response) {
		courseService.exportFile(response);

		ModelAndView mv = new ModelAndView();
		mv.addObject("type", "export");
		mv.setViewName("/WEB-INF/views/course/success.jsp");
		return mv;
	}
}
