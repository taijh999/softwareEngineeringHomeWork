package cn.byau.controller.admin;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.byau.pojo.User;
import cn.byau.service.LogInfoService;
import cn.byau.service.UserService;
import cn.byau.util.Result;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private LogInfoService logInfoService;
	@RequestMapping("/toUpdatePassword")
	// @ResponseBody
	public String toUpdatePassword() {

		return "/admin/user/updatePassword.jsp";
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
	@RequestMapping("/toUpdateUser")
	// @ResponseBody
	public String updateUserPage(HttpServletRequest request,HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		request.setAttribute("user", user);
		

		return "/admin/user/update.jsp";
	}
	

	
}
