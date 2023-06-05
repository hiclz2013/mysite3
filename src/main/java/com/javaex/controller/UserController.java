package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.JsonResult;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;

	/* 회원가입 폼 */
	@RequestMapping(value = "/joinForm", method = {RequestMethod.GET, RequestMethod.POST} )
	public String joinForm() {
		System.out.println("UserController.joinForm()");

		return "user/joinForm";
	}
	
	
	/* 회원가입 */
	@RequestMapping(value = "/join", method = {RequestMethod.GET, RequestMethod.POST} )
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join()");

		userService.join(userVo);
		
		return "user/joinOk";
	}
	
	
	/* 로그인 폼 */
	@RequestMapping(value = "/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");

		return "user/loginForm";
	}
	
	
	/* 로그인:회원정보 가져오기(세션저장용) */
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");

		UserVo authUser = userService.login(userVo);

		if (authUser != null) { // 로그인 성공일때
			System.out.println("로그인성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
			
		} else { // 로그인 실패일때
			System.out.println("로그인실패");
			return "redirect:/user/loginForm?result=fail";
			
		}
		
		
	}
	
	
	/* 로그아웃 */
	@RequestMapping(value="/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");

		// 세션의 값을 삭제한다.
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/main";
	}
	

	
	/* 회원정보수정폼:선택한 번호의 회의정보를 가져오기 */
	@RequestMapping(value="/modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("UserController.modifyForm()");

		// 세션에서 로그인한 사용자 no값 가져오기
		int no = ((UserVo) session.getAttribute("authUser")).getNo();

		// userService를 통해 로그인한 유저 모든정보 가져오기
		UserVo userVo = userService.modifyForm(no);

		// Dispacher Servlet에 유저정보 전달
		model.addAttribute("userVo", userVo);
		
		return "user/modifyForm";
	}

	
	
	// 회원수정
	@RequestMapping("/modify")
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.modify()");

		// 세션에서 로그인한 사용자 정보 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		// 가져온 세션정보에서 로그인한 사용자 no값 가져오기
		int no = authUser.getNo();

		// 파라미터로 넘어온 사용자 정보 UserVo에로 그인한 사용자 no값 추가
		userVo.setNo(no);

		// userService를 통해 로그인한 사용자 정보 수정
		userService.modify(userVo);

		// 세션에 이름 변경
		authUser.setName(userVo.getName());

		return "redirect:/main";
	}
	
	

	/* 회원가입 id체크 */
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult idcheck(@RequestParam("id") String id) {
		System.out.println("UserController.idcheck()");
		
		boolean data = userService.idcheck(id);
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(data);
		
		//jsonResult.fail("통신오류");
		
		/*
		 *getter setter 사용한 경우 --> 잘못 사용할 가능성이 높다
		jsonResult.setResult("success");
		jsonResult.setData(data);
		
		
		jsonResult.setResult("fail");
		jsonResult.setFailMsg("통신오류");
		*/
		
		System.out.println(jsonResult);
		
		return jsonResult;
	}
	
	
	
}
