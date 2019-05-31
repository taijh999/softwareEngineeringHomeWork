package cn.byau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.byau.service.CourseKindService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller
@RequestMapping("/courseKind")
public class CourseKindController {

	@Resource(name = "courseKindService")
	private CourseKindService courseKindService;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/WEB-INF/views/coursekind/list.jsp");
		mv.addObject("list", courseKindService.list());
		return mv;
	}

	@RequestMapping("/getByKindId")
	public ModelAndView getBykindId(HttpServletRequest request, HttpServletResponse response) {
		String kindId = request.getParameter("kindId");
		System.out.println(kindId);
		ModelAndView mv = new ModelAndView("/WEB-INF/views/coursekind/getByKindId.jsp");
		mv.addObject("courseKind", courseKindService.getByKindId(kindId));
		
		return mv;
	}
}