package cn.byau.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.byau.pojo.User;
import cn.byau.service.LogInfoService;
import cn.byau.service.UserService;
import cn.byau.util.Result;

@Controller
@RequestMapping("/user")
public class UserController {

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

		User user = userService.getUserByUserNameAndPassword(map);
		if (user == null) {
			session.setAttribute("msg", "用户名或密码错误");
			return "redirect:loginPage.action";
			// response.sendRedirect("jsp/index.jsp");
		} else {
			logInfoService.save(user.getUserId());

			session.setAttribute("user", user);
			return "redirect:index.action";
		}

	}

	@RequestMapping("/updatePassword")
	@ResponseBody
	public Result updatePassword(String password, String oldPassword, HttpSession session) {
		Result result = new Result();

		User user = (User) session.getAttribute("user");
		if (!user.getPassword().equals(oldPassword)) {
			result.setMsg("原密码错误");
		} else {
			user.setPassword(password);
			try {
				userService.update(user);
				result.setMsg("修改成功");
			} catch (Exception e) {
				// TODO: handle exception
				result.setMsg("修改失败");
			}
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	
	public Result handleFormUpload( HttpServletRequest request,
	
	User user) {
		// 判断所上传文件是否存在
			// 得到上传参数名
			// System.out.println(uploadfile.getName());
			// 获取上传文件的原始名称
		    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        MultipartFile uploadfile = multipartRequest.getFile("image1");
	
			String originalFilename = uploadfile.getOriginalFilename();
			String extFileName=originalFilename.substring(originalFilename.lastIndexOf("."));
			System.out.println(originalFilename);
			// 设置上传文件的保存地址目录
			String dirPath = request.getServletContext().getRealPath("/upload/");
			//System.out.println(dirPath); 
			// 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
			String newFilename = UUID.randomUUID()+extFileName;
			System.out.println(dirPath+newFilename); 
			
			user.setImage("upload/"+newFilename);
			System.out.println(user); 
			Result result = new Result();
			
			
			
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				uploadfile.transferTo(new File(dirPath + newFilename));
				userService.update(user);
				result.setMsg("OK");
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("FAIL"); 	
			}
			return result;

			
	}
	
//	public String handleFormUpload(@RequestParam("image") 
//	MultipartFile uploadfile, HttpServletRequest request,
//	@RequestParam("userId")
//	Integer userId,String userName) {
//		// 判断所上传文件是否存在
//		if (!uploadfile.isEmpty()) {
//			// 得到上传参数名
//			// System.out.println(uploadfile.getName());
//			// 获取上传文件的原始名称
//
//			String originalFilename = uploadfile.getOriginalFilename();
//			String extFileName=originalFilename.substring(originalFilename.lastIndexOf("."));
//			System.out.println(originalFilename);
//			// 设置上传文件的保存地址目录
//			String dirPath = request.getServletContext().getRealPath("/upload/");
//			//System.out.println(dirPath); 
//			// 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
//			String newFilename = UUID.randomUUID()+extFileName;
//			System.out.println(dirPath+newFilename); 
//			User user=new User();
//			user.setUserId(userId);
//			user.setUserName(userName);
//			user.setImage("upload/"+newFilename);
//			System.out.println(user); 
//			
//			try {
//				// 使用MultipartFile接口的方法完成文件上传到指定位置
//				uploadfile.transferTo(new File(dirPath + newFilename));
//				userService.update(user);
//				request.setAttribute("uploadFilePath", dirPath + newFilename);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return "uploaddemo/error.jsp";
//			}
//
//			// 跳转到成功页面
//			return "uploaddemo/success.jsp";
//		} else {
//			return "uploaddemo/error.jsp";
//		}
//	}
	public Result update(User user) {
		Result result = new Result();

		
			try {
				userService.update(user);
				result.setMsg("修改成功");
			} catch (Exception e) {
				// TODO: handle exception
				result.setMsg("修改失败");
			}
		
		return result;
	}

	

	@RequestMapping("/welcome")
	
	public void welcome(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write("<h1>欢迎使用本系统</h1>");
		
	}

	@RequestMapping("/updatePasswordPage")
	// @ResponseBody
	public String updatePasswordfirst() {

		return "/WEB-INF/views/user/updatePassword.jsp";
	}
	
	@RequestMapping("/updateUserPage")
	// @ResponseBody
	public String updateUserPage(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		request.setAttribute("user", user);
		

		return "/WEB-INF/views/user/update.jsp";
	}
	

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除Session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:loginPage.action";
	}

	@RequestMapping(value = "/index")
	public String index(HttpSession session) {
			return "/WEB-INF/views/index.jsp";
	}

	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "/WEB-INF/views/login.jsp";
	}
}
