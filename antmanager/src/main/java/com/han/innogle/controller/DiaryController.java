package com.han.innogle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.han.innogle.model.Diary;
import com.han.innogle.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	DiaryService diaryService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Authentication auth,Model model) {
		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			//글목록 보여주자.
			//사용자 아이디
			//
			List<Diary> diarys=diaryService.getDiarylist(auth.getName());
			model.addAttribute("diarys",diarys);
			return "diary";
		}
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value="user",required=false)String user ,
			@RequestParam(value="id",required=false)String id,Authentication auth,Model model) {
		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(user!=null&&id!=null) {
				Diary diary=diaryService.getDiary(Integer.parseInt(id));
				model.addAttribute("diary", diary);
			}
			return "diaryedit";
		}
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postedit(@Valid Diary diary,BindingResult result,Authentication auth) {
		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(result.hasErrors()) {
				System.out.println("====Web Form data does not validdated ====");
				List<ObjectError> errors=result.getAllErrors();
				for(ObjectError error:errors) {
					System.out.println(error.getDefaultMessage());
				}
				return "diaryedit";
			}
			diaryService.updateDiary(diary,auth);
			return "redirect:/diary/view";
		}
	}
	@RequestMapping(value = "/viewItem", method = RequestMethod.GET)
	public String viewItem(@RequestParam(value="user")String user,
			@RequestParam(value="id")String id,Authentication auth,Model model) {
		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(auth.getName().equals(user)) {
				//같다. 사용자 맞음
				Diary diary=diaryService.getDiary(Integer.parseInt(id));
				System.out.println(diary.toString());
				model.addAttribute("diary", diary);
				return "viewItem";
			}
			else {
				//내보내기 일단 홈으로
				return "redirect:/";
			}
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value="id")String id,Authentication auth) {
		String name=auth.getName();
		Diary dairy=diaryService.getDiary(Integer.parseInt(id));
		if(dairy.getUser().equals(name)) {//현재 접속자와 글주인이 같다면
			diaryService.deleteDiary(dairy);
		}
		return "redirect:/diary/view";
	}
	
}