package com.eduDashboardProject.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.sample.service.SampleService;
import com.eduDashboardProject.sample.service.dao.SampleDAO;

@Service("SampleService")
public class SampleServiceImpl implements SampleService {
	
	@Resource(name="SampleDAO")
	private SampleDAO sampleDAO;

	@Override
	public int login(UserVO userVO) throws Exception {
		return sampleDAO.login(userVO);
	}
	
}
