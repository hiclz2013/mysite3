package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	/* 키워드를 포함한 전체 글갯수 */
	public int totalCount2(String keyword) {
		System.out.println("BoardDao.totalCount()");
		
		Map<String, String> bMap = new HashMap<String, String>();
		bMap.put("keyword", keyword);
		
		int totalCount = sqlSession.selectOne("board.totalCount2", bMap);
		return totalCount;
	}
	
	/* 게시판 리스트: 페이징 포함 */
	public List<BoardVo> selectList4(int startRnum, int endRnum, String keyword){
		System.out.println("BoardDao.selectList4()");
		
		Map<String, Object> bMap = new HashMap<String, Object>();
		bMap.put("startRnum", startRnum);
		bMap.put("endRnum", endRnum);
		bMap.put("keyword", keyword);
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList4", bMap);
		
		return boardList;
	}
	
	
	
	/* 게시판 전체글 갯수 */
	public int totalCount() {
		System.out.println("BoardDao.totalCount()");
		
		int totalCount = sqlSession.selectOne("board.totalCount");
		return totalCount;
	}
	
	/* 게시판 리스트: 페이징 포함 */
	public List<BoardVo> selectList3(int startRnum, int endRnum){
		System.out.println("BoardDao.selectList3()");
		
		Map<String, Integer> bMap = new HashMap<String, Integer>();
		bMap.put("startRnum", startRnum);
		bMap.put("endRnum", endRnum);
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList3", bMap);
		
		return boardList;
	}
	
	
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
