package com.eduDashboardProject.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.login.service.LoginService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() throws Exception {
		return "login/login";
	}
	
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public boolean loginCheck(HttpServletRequest request, @ModelAttribute UserVO userVO) throws Exception {
		
		boolean result;
		HttpSession session = request.getSession();
		// 유저 정보가 일치하는지 확인
		result = loginService.loginCheck(userVO) > 0 ? true : false;
		session.setAttribute("user", result ? userVO : null);
		
		return result;
	}

}
