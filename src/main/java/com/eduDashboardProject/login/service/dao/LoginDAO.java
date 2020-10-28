package com.eduDashboardProject.login.service.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.eduDashboardProject.common.vo.UserVO;

@Repository("loginDAO")
public class LoginDAO {
	
	@Resource(name = "sqlsessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public int loginCheck(UserVO userVO) throws Exception {
		return (int) sqlSession.selectOne("user-mapper.selectUser", userVO);
	}
	
	public int insertUserHistory(Map<String, Object> map) throws Exception {
		return sqlSession.insert("user-mapper.insertUserHistory", map);
	}
}
