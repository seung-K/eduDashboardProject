package com.eduDashboardProject.admin.service.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.eduDashboardProject.admin.dto.BoardHistoryDTO;
import com.eduDashboardProject.admin.dto.UserHistoryDTO;

@Repository("historyDAO")
public class HistoryDAO {

	@Resource(name = "sqlsessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public List<UserHistoryDTO> getUserHistoryList() throws Exception {
		return sqlSession.selectList("history-mapper.selectUserHistory");
	}
	
	public List<BoardHistoryDTO> getBoardHistoryList() throws Exception {
		return sqlSession.selectList("history-mapper.selectBoardHistory");	
	}
}
