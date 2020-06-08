package com.han.innogle.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.han.innogle.model.User;
import com.han.innogle.model.UserSignInfo;
import com.han.innogle.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	//회원 등록, 수정, 탈퇴등...
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String getRssiter(@RequestParam(value="existId",required=false)String existId,
			@RequestParam(value="passchck",required=false)String passchck,
			@RequestParam(value="validId", required=false)String validId, Model model) throws Exception{
		if(existId!=null) {
			System.out.println("같은 아이디 있데");
			model.addAttribute("existId", existId+"와 같은 사용자가 있습니다.");
		}else {
			System.out.println("같은 아이디 없데");
			if(passchck!=null) {
				System.out.println("비번 통일시켜야함");
				if(validId!=null) 
				{				
					model.addAttribute("validId",validId);
				}
					model.addAttribute("passchck", "비밀번호를 통일하세요.");
			}else {
				System.out.println("비번 통일했음");
			}
		}
		
		return "signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String postRssiter(UserSignInfo userSignInfo) throws Exception{
		System.out.println("POST받음");
		//아이디가 있는지 체크
		int result = userService.idchk(userSignInfo.getUsername());
		System.out.println("result"+result);
		try {
			if(result==1) {//아이디 존재함
				//나중에 있다는걸 표시
				return "redirect:/user/signup?existId="+userSignInfo.getUsername();
			}
			else if(result ==0) {
				//아이디중복은 통과
				String inputPass = userSignInfo.getPassword();
				String inputPass2 = userSignInfo.getPassword2();
				if(inputPass.equals(inputPass2)) {
					User user=new User();
					user.setUsername(userSignInfo.getUsername());
					user.setPassword(inputPass);
					user.setEnabled(true);
					System.out.println("pwd 설정");
					userService.signup(user);
					return "redirect:/";
				}
				else {
					return "redirect:/user/signup?passchck=false&validId="+userSignInfo.getUsername();
				}
			}
			
		}catch(Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
				
	}
}