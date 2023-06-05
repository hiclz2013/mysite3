package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	/* 회원가입:회원정보 저장 */	
	public int join(UserVo userVo) {
		System.out.println("UserService.join()");
		
		int count =  userDao.insertUser(userVo);
		
		return count;
	}
	
	/* 로그인:회원정보 가져오기(세션저장용) */
	public UserVo login(UserVo userVo) {
		System.out.println("UserService.login()");
		
		UserVo authUser = userDao.selectUser(userVo);
		
		return authUser;
	}
	
	
	
	/* 회원정보수정폼:선택한 번호의 회의정보를 가져오기 */
	public UserVo modifyForm(int no) {
		System.out.println("UserService.modifyForm()");
		
		UserVo userVo = userDao.selectUser(no);
		
		return userVo;
	}
	
	
	
	//회원정보 수정
	public int modify(UserVo userVo) {
		System.out.println("UserService.modify()");
		
		int count = userDao.updateUser(userVo);
		
		return count;
	}
	
	
	
	
	/* 아이디 체크 */
	public boolean idcheck(String id) {
		System.out.println("UserService.idcheck()");
		UserVo userVo = userDao.selectUser(id);
		
		if(userVo == null) { //사용가능
			return true;
		}else {              //사용불가능
			return false;
		}
	}

	
	

}
