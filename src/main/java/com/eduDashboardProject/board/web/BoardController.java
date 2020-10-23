package com.eduDashboardProject.board.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduDashboardProject.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/list.do")
	public void getList(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("list", boardService.getList());
	}
}
