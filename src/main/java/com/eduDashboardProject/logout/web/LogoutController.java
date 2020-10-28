package com.eduDashboardProject.logout.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.logout.service.LogoutService;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

	@Resource(name = "logoutService")
	private LogoutService logoutService;

	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) throws Exception {

		String user_number = ((UserVO) request.getSession().getAttribute("userInfo")).getUser_number();
		request.getSession().invalidate();
		logoutService.insertLogoutHistory(user_number);

		return "/login/login";
	}

}
