package com.eduDashboardProject.regist.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.login.service.dao.LoginDAO;
import com.eduDashboardProject.regist.service.dao.RegistDAO;

@Service("registService")
public class RegistService {
	
	@Resource(name = "registDAO")
	private RegistDAO registDAO;
	@Resource(name = "loginDAO")
	private LoginDAO loginDAO;

	public int duplicateCheck(String id) throws Exception {
		return registDAO.duplicateCheck(id);
	}
	
	@Transactional
	public int insertUser(UserVO userVO) throws Exception {
		
		int result = registDAO.insertUser(userVO);
		
		if (result > 0) {
			HashMap<String, Object> param = new HashMap<>();
			param.put("user_number", userVO.getUser_number());
			param.put("comment", "회원가입");
			
			loginDAO.insertUserHistory(param);
		}
		
		return result;
	}
}

