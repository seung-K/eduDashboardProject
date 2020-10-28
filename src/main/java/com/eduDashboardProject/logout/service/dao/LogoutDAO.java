package com.eduDashboardProject.logout.service.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("logoutDAO")
public class LogoutDAO {
	
	@Resource(name = "sqlsessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public int insertLogoutHistory(HashMap<String, String> map) throws Exception {
		return (int) sqlSession.insert("user-mapper.insertUserHistory", map);
	}
}
