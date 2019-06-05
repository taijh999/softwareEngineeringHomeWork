package cn.byau.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.byau.pojo.User;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String requestURI = request.getRequestURI();

		// 获取Session
		HttpSession session = request.getSession();
		String path = request.getContextPath();

		String loginFlag = "";
		loginFlag = (String) session.getAttribute("loginFlag");
		if (requestURI.indexOf("/login.action") >= 0 || requestURI.indexOf("/loginPage.action") >= 0) {
			return true;
		} else if ("adminLogin".equals(loginFlag) && requestURI.startsWith(path + "/admin")
				|| "userLogin".equals(loginFlag) && requestURI.startsWith(path + "/user")) {
			return true;
		} else {
			request.setAttribute("msg", "请先登录");
			response.sendRedirect(path + "/user/loginPage.action");// 重定向
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
