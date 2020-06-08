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
	//ȸ�� ���, ����, Ż���...
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String getRssiter(@RequestParam(value="existId",required=false)String existId,
			@RequestParam(value="passchck",required=false)String passchck,
			@RequestParam(value="validId", required=false)String validId, Model model) throws Exception{
		if(existId!=null) {
			System.out.println("���� ���̵� �ֵ�");
			model.addAttribute("existId", existId+"�� ���� ����ڰ� �ֽ��ϴ�.");
		}else {
			System.out.println("���� ���̵� ����");
			if(passchck!=null) {
				System.out.println("��� ���Ͻ��Ѿ���");
				if(validId!=null) 
				{				
					model.addAttribute("validId",validId);
				}
					model.addAttribute("passchck", "��й�ȣ�� �����ϼ���.");
			}else {
				System.out.println("��� ��������");
			}
		}
		
		return "signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String postRssiter(UserSignInfo userSignInfo) throws Exception{
		System.out.println("POST����");
		//���̵� �ִ��� üũ
		int result = userService.idchk(userSignInfo.getUsername());
		System.out.println("result"+result);
		try {
			if(result==1) {//���̵� ������
				//���߿� �ִٴ°� ǥ��
				return "redirect:/user/signup?existId="+userSignInfo.getUsername();
			}
			else if(result ==0) {
				//���̵��ߺ��� ���
				String inputPass = userSignInfo.getPassword();
				String inputPass2 = userSignInfo.getPassword2();
				if(inputPass.equals(inputPass2)) {
					User user=new User();
					user.setUsername(userSignInfo.getUsername());
					user.setPassword(inputPass);
					user.setEnabled(true);
					System.out.println("pwd ����");
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