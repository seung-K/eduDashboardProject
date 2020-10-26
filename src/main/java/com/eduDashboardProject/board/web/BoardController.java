package com.eduDashboardProject.board.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eduDashboardProject.board.dto.BoardDTO;
import com.eduDashboardProject.board.service.BoardService;
import com.eduDashboardProject.common.vo.UserVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/list.do")
	public ModelAndView getList(HttpServletRequest request, ModelAndView mv) throws Exception {
		mv.setViewName("/board/list");
		mv.addObject("list", boardService.getList());
		
		return mv;
	}
	
	@RequestMapping(value = "/getDetail.do")
	public ModelAndView getDetail(HttpServletRequest request, @RequestParam(value = "board_number", required = true) String board_number, ModelAndView mv) throws Exception {
		mv.setViewName("/board/board-detail");
		mv.addObject("boardDTO", boardService.getDetail(board_number));
		mv.addObject("type", "detail");
		
		return mv;
	}
	
	@RequestMapping(value = "writeBoard.do")
	@ResponseBody
	public ModelAndView writeBoard(HttpServletRequest request, ModelAndView mv) throws Exception {
		
		HttpSession session = request.getSession();
		
		Map<String, String> map = new HashMap<>();
		map.put("user_number", ((UserVO)session.getAttribute("userInfo")).getUser_number());
		map.put("identification", ((UserVO)session.getAttribute("userInfo")).getIdentification());
		
		mv.setViewName("/board/board-detail");
		mv.addObject("info", map);
		mv.addObject("type", "wirte");

		return mv;
	}
	
	@RequestMapping(value = "insertBoard.do", method=RequestMethod.POST)
	@ResponseBody
	public int insertBoard(HttpServletRequest request, @ModelAttribute("boardDTO") BoardDTO boardDTO) throws Exception {
		return boardService.insertBoard(boardDTO);
	}
	
	@RequestMapping(value = "/modifyBoard.do", method=RequestMethod.POST)
	@ResponseBody
	public int modifyBoard(HttpServletRequest request, @ModelAttribute("boardDTO") BoardDTO boardDTO) throws Exception {
		return boardService.ModifyBoard(boardDTO);
	}

	@RequestMapping(value = "/deleteBoard.do", method=RequestMethod.POST)
	@ResponseBody
	public int deleteBoard(HttpServletRequest request, @RequestParam(value = "board_number", required = true) String board_number) throws Exception {
		return boardService.deleteBoard(board_number);
	}
	
}
