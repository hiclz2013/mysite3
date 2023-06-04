package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	/* 게시판 리스트: 검색기능 포함 */
	public List<BoardVo> getList2(String keyword) {
		System.out.println("BoardService.getList2()");
		
		List<BoardVo> boardList = boardDao.selectList2(keyword);
		
		return boardList;
	}
	
	
	/* 게시판 리스트: 검색기능 X */
	public List<BoardVo> getList() {
		System.out.println("BoardService.getList()");
		
		List<BoardVo> boardList = boardDao.selectList();
		
		return boardList;
	}
	
	
	// 글쓰기
	public int addBoard(BoardVo boardVo) {
		System.out.println("BoardService.addBoard()");

		int count = boardDao.insertBoard(boardVo);
		return count;
	}
	
	
}
