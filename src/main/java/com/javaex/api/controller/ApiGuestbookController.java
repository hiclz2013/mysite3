package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.JsonResult;

@Controller
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	//ajax방명록 첫페이지(기본방식으로 구현)
	@RequestMapping(value = "/api/guestbook/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("ApiGuestbookController.addList()");
		
		List<GuestbookVo> guestbookList = guestbookService.getGuestList();
		System.out.println(guestbookList);
		
		model.addAttribute("guestbookList", guestbookList);
		
		return "guestbook/ajaxList";
	}
	
	
	
	
	
	//ajax 등록
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/add", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController.add()");
		//System.out.println(guestbookVo);
		
		GuestbookVo guestVo = guestbookService.addGuest(guestbookVo);
		
		//jsonResult에 담기
		JsonResult jsonResult = new JsonResult();	
		jsonResult.success(guestVo);
		
		return jsonResult;
	}
	
	//ajax 삭제
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult remove(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController.remove()");
		System.out.println(guestbookVo);
		
		int count = guestbookService.removeGuest(guestbookVo);
		System.out.println(count);
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(count);
		
		return jsonResult;
	}
	
	
	
	
	
	
	
	
	
	
}
