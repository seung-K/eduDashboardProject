package com.eduDashboardProject.board.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduDashboardProject.board.dto.BoardDTO;
import com.eduDashboardProject.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/list.do")
	public String getList(HttpServletRequest request, Model model) throws Exception {
		
		List<BoardDTO> list = boardService.getList();
		for (BoardDTO dto : list) {
			System.out.println(dto.getComment());
		}
		model.addAttribute("list", list);
		
		return "/board/list"; 
	}
}
