package com.eduDashboardProject.regist.service.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.eduDashboardProject.common.vo.UserVO;

@Repository("registDAO")
public class RegistDAO {

	@Resource(name = "sqlsessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public int duplicateCheck(String id) throws Exception {
		return sqlSession.selectOne("user-mapper.selectUserId", id);
	}
	
	public int insertUser(UserVO userVO) throws Exception {
		return sqlSession.insert("user-mapper.insertUser", userVO);
	}
	
}
