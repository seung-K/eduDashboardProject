package com.eduDashboardProject.login.service.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAO {
	
	@Resource(name = "sqlsessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public String loginCheck(String id, Object object) {
		return sqlSession.selectOne(id, object);
	}
}
