package com.bs.sxd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String username, String password, Integer type, Model model, HttpSession session) {
		// System.out.println(username);
		User user = userService.findUser(username, password, type);
		if (user != null) {
			if (user.getType() == 0) {
				session.setAttribute("USER_SESSION", user);
				return "main";
			} else {
				return "admin";
			}

		} else {
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

	// �����û�ע��ı��ύ
	@RequestMapping(value = "/register.action")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/person.action")
	public String person() {
		return "person";
	}

	@RequestMapping(value = "/zulinShop.action")
	public String zulinShop() {
		return "zulinShop";
	}
	@RequestMapping(value = "/table-font-list.action")
	public String table_font_list() {
		return "table-font-list";
	}
	@RequestMapping(value = "/table-images-list.action")
	public String table_images_list() {
		return "table-images-list";
	}
	@RequestMapping(value = "/form-news.action")
	public String form_news() {
		return "form-news";
	}
	@RequestMapping(value = "/form-amazeui.action")
	public String form_amazeui() {
		return "form-amazeui";
	}
	@RequestMapping(value = "/form-line.action")
	public String form_line() {
		return "form-line";
	}

	@RequestMapping(value = "/add.action", method = RequestMethod.POST)
	public String register(User user, String username, String password, String phone, String qq, String sex,
			String university, String college, String adreess) {
		//System.out.println(username);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);
		user.setQq(qq);
		user.setUniversity(university);
		user.setCollege(college);
		user.setAdreess(adreess);
		Integer type = 0;
		user.setType(type);
		//System.out.println(user);
		User u = null;
		u = userService.findByUserName(username);
		if (u == null) {
			System.out.println(u);
			userService.addUser(user);
			return "login";
		} else {
			return "register";
		}
		// return "register";
	}

}
