package cn.byau.controller.admin;

import java.util.HashMap;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.byau.entity.LogInfo;
import cn.byau.service.LogInfoService;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller
@RequestMapping("/admin/log")
public class LogInfoController {

	@Autowired
	private LogInfoService logInfoService;

	@RequestMapping("/listByPage")
	public String pageList(ModelMap map,
			@RequestParam(defaultValue="1",required=false) Integer pageNum,
			@RequestParam(defaultValue="5",required=false)  Integer pageSize,
			@RequestParam(defaultValue="",required=false)  String startTime,   
			@RequestParam(defaultValue="",required=false)  String endTime   
			)throws Exception{
        HashMap<String,String> hm=new HashMap<>();

        hm.put("startTime",startTime);
        hm.put("endTime",endTime);
        PageInfo<LogInfo> pageInfo=logInfoService.listByPage(pageNum, pageSize,hm);
        map.addAttribute("pageInfo", pageInfo);
        return "/admin/loginfo/list.jsp";
    }

}
