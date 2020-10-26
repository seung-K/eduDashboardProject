package com.eduDashboardProject.board.service.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.eduDashboardProject.board.dto.BoardDTO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Resource(name = "sqlsessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	public List<BoardDTO> getList() throws Exception {
		return sqlSession.selectList("board-mapper.selectList");
	}
	
	public BoardDTO getDetail(int board_number) throws Exception {
		return sqlSession.selectOne("board-mapper.getDetail", board_number);
	}
	
	public int insertBoard(BoardDTO boardDTO) throws Exception {
		return (int) sqlSession.insert("board-mapper.insertBoard", boardDTO);
	}
	
	public int modifyBoard(BoardDTO boardDTO) throws Exception {
		return (int) sqlSession.update("board-mapper.modifyBoard", boardDTO);
	}

	public int deleteBoard(String board_number) throws Exception {
		return (int) sqlSession.delete("board-mapper.deleteBoard", board_number);
	}
}
