package cn.byau.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.byau.pojo.LogInfo;
import cn.byau.service.LogInfoService;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller
@RequestMapping("/log")
public class LogInfoController {

	@Resource(name = "logInfoService")
	private LogInfoService logInfoService;

	@RequestMapping("/list")
	public String pageList(ModelMap map,
			@RequestParam(defaultValue="1",required=false) Integer pageNo,
			@RequestParam(defaultValue="5",required=false)  Integer pageSize,
			@RequestParam(defaultValue="",required=false)  String startTime,   
			@RequestParam(defaultValue="",required=false)  String endTime   
			)throws Exception{
       
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        HashMap<String,String> hm=new HashMap<>();
//        if(!startTime.equals("")) {
//        hm.put("startTime", new SimpleDateFormat("YYYY-MM-dd HH:mm").parse(startTime));
//        }
//        if(!endTime.equals("")) {
//        hm.put("endTime", new SimpleDateFormat("YYYY-MM-dd HH:mm").parse(endTime));
//        }
        hm.put("startTime",startTime);
        hm.put("endTime",endTime);
        
        System.out.println("xxxx="+startTime);
        System.out.println("yyyyyyyyyyyyyy"+endTime);
        
        List<LogInfo> userList = logInfoService.list(hm);//获取所有用户信息
        System.out.println(userList);
        PageInfo<LogInfo> pageInfo=new PageInfo<LogInfo>(userList);
        map.addAttribute("pageInfo", pageInfo);
        return "/WEB-INF/views/loginfo/list.jsp";
    }


//	public ModelAndView list(HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("/WEB-INF/views/loginfo/list.jsp");
//		mv.addObject("list", logInfoService.list());
//		// mv.setViewName("/success");
//		return mv;
//	}
}