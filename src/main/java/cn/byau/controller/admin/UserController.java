package cn.byau.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.byau.entity.User;
import cn.byau.service.UserService;
import cn.byau.util.Result;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/toUpdatePassword")
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

}
