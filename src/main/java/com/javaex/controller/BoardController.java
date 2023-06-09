package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/* 게시판 리스트 페이징기능 포함 */
	@RequestMapping(value="/list3", method= {RequestMethod.GET, RequestMethod.POST})
	public String list3(@RequestParam(value="crtPage", required = false, defaultValue = "1" ) int crtPage,    Model model) {
		System.out.println("BoardController.list3()");
		
		Map<String, Object> pMap= boardService.getList3(crtPage);
		model.addAttribute("pMap", pMap );
		
		System.out.println(pMap);
		/*
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		pMap.put("boardList", boardList);
		*/
		
		return "board/list3";
	}
	
	
	
	
	
	/* 게시판 리스트: 검색기능 포함 */
	@RequestMapping(value="/list2", method= {RequestMethod.GET, RequestMethod.POST})
	public String list2(@RequestParam(value="keyword", required = false, defaultValue = "") String keyword, 
					   Model model) {
		System.out.println("BoardController.list2()");
		
		List<BoardVo> boardList = boardService.getList2(keyword);
		model.addAttribute("boardList", boardList );
		
		return "board/list";
	}
	
	
	/* 게시판 리스트: 검색기능 X*/
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVo> boardList = boardService.getList();
		System.out.println(boardList);
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	
	
	/* 게시판 글쓰기 폼 */
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(Model model) {
		System.out.println("BoardController.writeForm()");
		
		return "board/writeForm";
	}
	
	
	
	/* 게시판 글쓰기 */
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		System.out.println("BoardController.write()");

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		boardVo.setUserNo(authUser.getNo());

		//boardService.addBoard(boardVo);
		
		return "redirect:/board/list";
	}

	
	
	
	

}
