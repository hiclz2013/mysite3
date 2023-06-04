package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	/* 회원가입:회원정보 저장 */
	public int insertUser(UserVo userVo) {
		System.out.println("UserDao.insert()");
		
		int count = sqlSession.insert("user.insert", userVo);
		
		return count;
	}
	
	//////////////////////////////////////////////////////////////////
	
	/* 로그인:회원정보 가져오기(세션저장용) */
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao.selectUser(userVo)");
		
		UserVo authVo = sqlSession.selectOne("user.selectUser", userVo);
		return authVo;
	}
	
	

	/* 회원정보수정폼:선택한 번호의 회의정보를 가져오기 */
	public UserVo selectUser(int no) {
		System.out.println("UserDao.selectUser(no)");
		
		UserVo userVo = sqlSession.selectOne("user.selectUserByNo", no);
		return userVo;
	}
	
	
	
	//회원정보 수정
	public int updateUser(UserVo userVo) {
		System.out.println("UserDao.updateUser()");
		
		return sqlSession.update("user.update", userVo);
	}
	
	
	
	//아이디체크-->(ajax 용)
	public UserVo selectUser(String id) {
		System.out.println("UserDao.selectUser()");
		
		UserVo userVo = sqlSession.selectOne("user.selectUserById", id);
		
		return userVo;
	}
	
	
}
