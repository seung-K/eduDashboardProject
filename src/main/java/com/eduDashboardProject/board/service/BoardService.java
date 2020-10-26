package com.eduDashboardProject.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eduDashboardProject.board.dto.BoardDTO;
import com.eduDashboardProject.board.service.dao.BoardDAO;

@Service("boardService")
public class BoardService {

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;
	
	public List<BoardDTO> getList() throws Exception {
		
		List<BoardDTO> boardDTOList = new ArrayList<>();
		boardDTOList = boardDAO.getList();
		
		for (BoardDTO dto : boardDTOList) {
			dto.makeInsertDateFormmat(dto.getCreate_date());
		}
		
		return boardDTOList;
	}
	
	public BoardDTO getDetail(String board_number) throws Exception {
		return boardDAO.getDetail(Integer.parseInt(board_number));
	}
	
	public int insertBoard(BoardDTO boardDTO) throws Exception {
		return boardDAO.insertBoard(boardDTO);
	}
	
	public int ModifyBoard(BoardDTO boardDTO) throws Exception {
		return boardDAO.modifyBoard(boardDTO);
	}

	public int deleteBoard(String board_number) throws Exception {
		return boardDAO.deleteBoard(board_number);
	}
}
