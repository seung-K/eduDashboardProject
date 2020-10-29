package com.eduDashboardProject.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduDashboardProject.board.dto.BoardDTO;
import com.eduDashboardProject.admin.dto.BoardHistoryDTO;
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
		return boardDAO.getDetail(board_number);
	}
	
	@Transactional
	public int insertBoard(BoardDTO boardDTO) throws Exception {
		
		int result = boardDAO.insertBoard(boardDTO);
		
		if (result > 0) {
			BoardHistoryDTO historyDTO = new BoardHistoryDTO();
			historyDTO.setBoard_number(boardDTO.getBoard_number());
			historyDTO.setUser_number(boardDTO.getUser_number());
			historyDTO.setComment("글 작성");
			
			boardDAO.insertBoardHistory(historyDTO);
		}
		
		return result;
	}
	
	@Transactional
	public int ModifyBoard(BoardDTO boardDTO) throws Exception {
		
		int result = boardDAO.modifyBoard(boardDTO);
		
		if (result > 0) {
			BoardHistoryDTO historyDTO = new BoardHistoryDTO();
			historyDTO.setBoard_number(boardDTO.getBoard_number());
			historyDTO.setUser_number(boardDTO.getUser_number());
			historyDTO.setComment("글 수정");
			
			boardDAO.insertBoardHistory(historyDTO);
		}
		
		return result;
	}

	@Transactional
	public int deleteBoard(String board_number, String user_number) throws Exception {
		
		int result = boardDAO.deleteBoard(board_number);
		
		if (result > 0) {
			BoardHistoryDTO historyDTO = new BoardHistoryDTO();
			historyDTO.setBoard_number(board_number);
			historyDTO.setUser_number(user_number);
			historyDTO.setComment("글 삭제");
			
			boardDAO.insertBoardHistory(historyDTO);
		}
		
		return result;
	}
}
