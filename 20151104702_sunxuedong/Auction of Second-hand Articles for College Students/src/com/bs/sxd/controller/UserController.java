package com.bs.sxd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.sxd.po.User;
import com.bs.sxd.service.UserService;

/**
 * �û���������
 * 
 * @author ��ѩ��
 *
 */
@Controller
public class UserController {
	// ����ע��
	@Autowired
	private UserService userService;

	/*
	 * ��½
	 */
	@RequestMapping(value="/login.action", method = RequestMethod.POST)
	public String login(String username, String password,Model model, HttpSession session) {
		User user = userService.findUser(username, password);
		if (user != null) {
		 if(user.getType() == 0){
			 session.setAttribute("USER_SESSION", user);
			   return "main";
		}else{
			return "admin";
		}
		  
			 
		}else
		{
		model.addAttribute("msg", "�˺Ż�������󣡣�");
		return "login";
		}
	}
	/**
	 * �˳���¼
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
	    // ���Session
	    session.invalidate();
	    // �ض��򵽵�¼ҳ�����ת����
	    return "redirect:login.action";
	}

}
