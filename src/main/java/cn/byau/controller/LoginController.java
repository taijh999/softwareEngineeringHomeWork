package cn.byau.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.byau.pojo.User;
import cn.byau.service.LogInfoService;
import cn.byau.service.UserService;
import cn.byau.util.CommonUtils;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private LogInfoService logInfoService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();

		map.put("userName", userName);
		map.put("password", password);
        String r1=""; 
		User user = userService.getUserByUserNameAndPassword(map);
		if (user != null) {
		if (user.getRoleId().equals(CommonUtils.ADMIN_ROLE)) {
			session.setAttribute("user", user);
			session.setAttribute("loginFlag", "adminLogin");

			r1= "redirect:/admin/index.jsp";
		} else if (user.getRoleId().equals(CommonUtils.USER_ROlE)){
			session.setAttribute("user", user);
			session.setAttribute("loginFlag", "userLogin");
		    
			r1= "redirect:/user/index.jsp";
		}
		}else {
			 session.setAttribute("msg", "用户名或密码错误");
			r1="redirect:/login.jsp";
		}
			return r1;
		}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除Session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:/login.jsp";
	}
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String loginPage() {
		return "redirect:/login.jsp";
	}
}
