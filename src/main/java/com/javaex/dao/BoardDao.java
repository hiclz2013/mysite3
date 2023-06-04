package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	/* 게시판 리스트: 검색기능 포함 */
	public List<BoardVo> selectList2(String keyword) {
		System.out.println("BoardDao.selectList2()");
	
		List<BoardVo> boardList = sqlSession.selectList("board.selectList2", keyword);
		
		return boardList;
	}
	
	
	/* 게시판 리스트: 검색기능 X : 메소드이름에 2가 붙어 있음*/
	public List<BoardVo> selectList() {
		System.out.println("BoardDao.selectList()");
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList");
		
		return boardList;
	
	}
	
	
	/* 글저장 */
	public int insertBoard(BoardVo boardVo) {
		System.out.println("BoardDao.insertBoard()");

		int count = sqlSession.insert("board.insert", boardVo);
		return count;
	}
	
}
