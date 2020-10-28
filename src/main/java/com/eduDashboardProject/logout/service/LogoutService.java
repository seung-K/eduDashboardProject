package com.eduDashboardProject.logout.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eduDashboardProject.logout.service.dao.LogoutDAO;

@Service("logoutService")
public class LogoutService {
	
	@Resource(name = "logoutDAO")
	private LogoutDAO logoutDAO;
	
	public int insertLogoutHistory(String user_number) throws Exception {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_number", user_number);
		map.put("comment", "로그아웃");
		
		return logoutDAO.insertLogoutHistory(map);
	}
}
