package cn.byau.controller.user;

import java.io.File;
import java.io.IOException;
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
@RequestMapping("/user/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/toUpdatePassword")

	public String toUpdatePassword() {

		return "/user/user/updatePassword.jsp";
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

	@RequestMapping("/toUpdateUser")
	public String updateUserPage(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		return "/user/user/update.jsp";
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Result updateUser(HttpServletRequest request,
			User user) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("image1");
		// 判断所上传文件是否存在
		if (uploadFile != null) {
			// 获取上传文件的原始名称
			String originalFilename = uploadFile.getOriginalFilename();
			String extFileName = originalFilename.substring(originalFilename.lastIndexOf("."));
			// System.out.println(originalFilename);
			// 设置上传文件的保存地址目录
			String dirPath = request.getServletContext().getRealPath("/upload/");
			// System.out.println(dirPath);
			// 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
			String newFilename = UUID.randomUUID() + extFileName;
			// System.out.println(dirPath+newFilename);

			user.setImage("upload/" + newFilename);
			//System.out.println(user);
            //完成上传    
			uploadFile.transferTo(new File(dirPath + newFilename));
		}
		Result result = new Result();
		try {
			userService.update(user);
			result.setMsg("OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("FAIL");
		}
		return result;
	}



}
