package com.eduDashboardProject.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.login.service.dao.LoginDAO;

@Service("loginService")
public class LoginService {
	
	@Resource(name = "loginDAO")
	private LoginDAO loginDAO;

	public String loginCheck(UserVO userVO) throws Exception {
		return loginDAO.loginCheck("user-mapper.selectUser", userVO);
	}

}
