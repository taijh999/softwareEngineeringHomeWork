package cn.byau.controller;

import java.io.IOException;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

import cn.byau.pojo.Course;
import cn.byau.pojo.CourseKind;
import cn.byau.pojo.User;
import cn.byau.service.CourseKindService;
import cn.byau.util.Result;

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
	@RequestMapping("/getDataGrid")
	// 浏览器直接测试 /testJson13?page=1&rows=2 这种形式
		public void datagrid(Integer page, Integer rows, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");   //请求跨域
        response.setContentType("text/json;charset=UTF-8");
		
		PageInfo<CourseKind> pageInfo=courseKindService.listByPage(page, rows);
			long total=pageInfo.getTotal();
			ObjectMapper mapper = new ObjectMapper();
			// 返回JSON格式的响应
			try {
				String json = "{\"total\":"+total+",\"rows\":" + mapper.writeValueAsString(pageInfo.getList())  + "}";
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
	@RequestMapping("/save")
	@ResponseBody
	public Result save(CourseKind courseKind) {
		
		
		Result result = new Result();
		if(courseKindService.getByKindId(courseKind.getKindId())==null){
		try{
			courseKindService.save(courseKind);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL"); 		
		}
		}else {
			 result.setMsg("主键重复");
		}
		return result;
	

	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Result update(CourseKind courseKind) {
		Result result = new Result();
		try{
			courseKindService.update(courseKind);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL"); 		
		}
		return result;
		

	}
	

	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(String courseKindId) {
		Result result = new Result();
		try{
			courseKindService.delete(courseKindId);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL"); 		
		}
		return result;
	}
}