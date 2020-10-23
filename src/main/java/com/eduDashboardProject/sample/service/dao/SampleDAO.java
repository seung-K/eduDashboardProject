package com.eduDashboardProject.sample.service.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.eduDashboardProject.common.service.dao.BaseDAO;
import com.eduDashboardProject.common.vo.UserVO;

@Repository("SampleDAO")
public class SampleDAO {
	
	@Resource(name="BaseDAO")
	private BaseDAO baseDAO;
	
	public int login(UserVO userVO) throws Exception {
		return (int) baseDAO.selectObject("sampleMapper.selectUser", userVO);
	}
}