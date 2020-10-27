package com.eduDashboardProject.login.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
	
	@RequestMapping(value="/main.do")
	public String main() throws Exception {
		return "login/login";
	}
	
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> loginCheck(HttpServletRequest request, @ModelAttribute("userVO") UserVO userVO) throws Exception {

		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		HttpSession session = request.getSession();

		// 유저 정보가 일치하는지 확인
		userVO.setUser_number(loginService.loginCheck(userVO));
		boolean result = !StringUtils.isEmpty(userVO.getUser_number()) ? true : false;
		
		resultMap.put("result", result);
		session.setAttribute("userInfo", result ? userVO : null);
		
		return resultMap;
	}

}