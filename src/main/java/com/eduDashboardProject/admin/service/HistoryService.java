package com.eduDashboardProject.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eduDashboardProject.admin.dto.BoardHistoryDTO;
import com.eduDashboardProject.admin.dto.UserHistoryDTO;
import com.eduDashboardProject.admin.service.dao.HistoryDAO;

@Service("historyService")
public class HistoryService {

	@Resource(name = "historyDAO")
	private HistoryDAO historyDAO;
	
	public List<UserHistoryDTO> getUserHistoryList() throws Exception {
		return historyDAO.getUserHistoryList();
	}
	
	public List<BoardHistoryDTO> getBoardHistoryList() throws Exception {
		return historyDAO.getBoardHistoryList();
	}
}
