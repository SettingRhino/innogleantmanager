package com.han.innogle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.han.innogle.model.Diary;
import com.han.innogle.model.User;
import com.han.innogle.model.UserSignInfo;
import com.han.innogle.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	//ȸ�� ���, ����, Ż���...
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="forgetpassword", method=RequestMethod.GET)
	public String getforgetpassword(@RequestParam(value="existId",required=false)String existId,
			@RequestParam(value="username",required=false)String username, Model model) throws Exception{
		//���ã��
		if(existId==null&&username==null) {//ó��
			model.addAttribute("start","start");
			return "forgetpassword";
		}
		
		//���̵����� Ȯ��&& ���� ����
		if(username!=null) {//�̸� �Ѿ��->������ȸ->�ִ� ����.
			System.out.println(username);
			int result = userService.idchk(username);
			if(result==0){//��������
				String notExistId="���̵� �������� �ʽ��ϴ�.";
				model.addAttribute("username",username);
				model.addAttribute("notExistId", notExistId);
				model.addAttribute("start","start");//�ٽ� ó������
			}else {//�����ִ�.
				boolean confirmchk=userService.userconfirmchk(username);
				if(confirmchk) {//�䵵 �ߴ� //�𵨿� �̸�, ��й�ȣ ��.
					User user=userService.getUserByName(username);
					model.addAttribute("username",user.getUsername());
					model.addAttribute("userconfirmquestion",user.getUserconfirmquestion());
				}
				else {
					String notconfirmchk="��й�ȣ ��Ʈ�� �������� �ʾ� �Ұ��մϴ�.";
					model.addAttribute("notconfirmchk",notconfirmchk);
				}
			}
		}
		//��ƮȮ�� �������->post
		return "forgetpassword";
	}
	@RequestMapping(value="forgetpassword", method=RequestMethod.POST)
	public String postforgetpassword(UserSignInfo userSignInfo, Model model) throws Exception{
		System.out.println("forgetpassword POST ---- "+userSignInfo.toString());
		boolean answerchk= userService.answerchk(userSignInfo.getUsername(),userSignInfo.getUserconfirmanswer());
		System.out.println("---------forgetpassword POST answerchk"+Boolean.toString(answerchk)+"---------");
		if(answerchk) {//���� ����.
			if(userService.updateUserpw(userSignInfo)) {
				model.addAttribute("pwupdateok", "��й�ȣ����Ϸ�");
				return "/login";
			}else {
				model.addAttribute("passchck","��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				return "/user/forgetpassword?username="+userSignInfo.getUsername();
			}
		}
			//���� �ٸ���
		model.addAttribute("answerchck","��й�ȣ��Ʈ�� ��ġ���� �ʽ��ϴ�.");
		return "/user/forgetpassword?username="+userSignInfo.getUsername();
	}
	
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
				if(userService.signup(userSignInfo)) {
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