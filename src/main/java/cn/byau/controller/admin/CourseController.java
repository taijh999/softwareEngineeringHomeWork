package cn.byau.controller.admin;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.byau.pojo.Course;
import cn.byau.pojo.CourseKind;

import cn.byau.service.CourseKindService;
import cn.byau.service.CourseService;
import cn.byau.util.Result;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller("adminCourseController")
@RequestMapping("/admin/course")
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
	@RequestMapping("/toSave")
	public String savePage(HttpServletRequest request) {
		List<CourseKind> list = courseKindService.list();
		request.setAttribute("list", list);
		return "/admin/course/save.jsp";
	}

	/**
	 * 跳转到上传页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpload")
	public String upload() {
		return "/admin/course/upload.jsp";
	}

	/**
	 * 跳转到分页显示页面
	 * 
	 * @param pageNum  为当前页号
	 * @param courseId 为查询的课程编号
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/listByPage")
	public String listByPage(@RequestParam(defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "", required = false) String courseId, HttpServletRequest request,
			HttpServletResponse response) {
		PageInfo<Course> pageInfo = courseService.listByPage(pageNum, pageSize, courseId);
		request.setAttribute("pageInfo", pageInfo);

		request.setAttribute("courseId", courseId);
		return "/admin/course/list.jsp";

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
		try {
			courseService.save(course);
			result.setMsg("OK");
		} catch (Exception e) {
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

	@RequestMapping("/toUpdate")
	public ModelAndView updatePage(HttpServletRequest request) {
		String courseId = request.getParameter("courseId");
		Course course = courseService.getById(courseId);

		ModelAndView mv = new ModelAndView("/admin/course/update.jsp");
		mv.addObject("course", course);

		List<CourseKind> list = courseKindService.list();
		mv.addObject("list", list);

		return mv;
	}
	

	@RequestMapping("/update")
	@ResponseBody
	public Result update(Course course) {
		Result result = new Result();
		try {
			courseService.update(course);
			result.setMsg("OK");
		} catch (Exception e) {
			result.setMsg("FAIL");
		}
		return result;

	}

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public Result deleteBatch(String courseIds) {
		Result result = new Result();
		String ids[] = courseIds.split(",");
		List<String> idList = Arrays.asList(ids);
		courseService.deleteBatch(idList);
		result.setMsg("OK");
		return result;
	}

	@RequestMapping("/importFile")
	public String importFile(@RequestParam(value = "uploadFile") MultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response) {
		String rootPath = request.getServletContext().getRealPath("/upload/");
		String msg = courseService.importFile(mFile, rootPath);
		request.setAttribute("msg", msg);
		return "/admin/course/upload.jsp";
	}

	@RequestMapping("/exportFile")
	public ModelAndView exportFile(HttpServletResponse response) {
		courseService.exportFile(response);

		ModelAndView mv = new ModelAndView();
		mv.addObject("type", "export");
		mv.setViewName("/admin/course/success.jsp");
		return mv;
	}
}
