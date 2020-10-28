package com.eduDashboardProject.login.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.login.service.dao.LoginDAO;

@Service("loginService")
public class LoginService {
	
	@Resource(name = "loginDAO")
	private LoginDAO loginDAO;

	@Transactional
	public int loginCheck(UserVO userVO) throws Exception {
		int user_number = loginDAO.loginCheck(userVO);
		
		if (user_number > 0) {
			
			HashMap<String, Object> param = new HashMap<>();
			param.put("user_number", user_number);
			param.put("comment", "로그인");
			
			loginDAO.insertUserHistory(param);
		}
		return user_number;
	}

}
