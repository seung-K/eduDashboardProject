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
}
