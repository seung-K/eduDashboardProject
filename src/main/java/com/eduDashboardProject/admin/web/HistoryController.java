package com.eduDashboardProject.admin.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduDashboardProject.admin.dto.BoardHistoryDTO;
import com.eduDashboardProject.admin.dto.UserHistoryDTO;
import com.eduDashboardProject.admin.service.HistoryService;

@Controller
@RequestMapping(value = "/history")
public class HistoryController {
	
	@Resource(name = "historyService")
	private HistoryService historyService;
	
	@RequestMapping(value = "/userHistory.do", method=RequestMethod.POST)
	@ResponseBody
	public List<UserHistoryDTO> getUserHistroyList(HttpServletRequest request) throws Exception {
		
		List<UserHistoryDTO> list = new ArrayList<>();
		list = historyService.getUserHistoryList();
		
		return list;
	}
	
	@RequestMapping(value = "/boardHistory.do",method=RequestMethod.POST)
	@ResponseBody
	public List<BoardHistoryDTO> getBoardHistoryList() throws Exception {
		
		List<BoardHistoryDTO> list = new ArrayList<>();
		list = historyService.getBoardHistoryList();
		
		return list;
	}
	

}

