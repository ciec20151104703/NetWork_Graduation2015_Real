
package cn.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cn.chat.pojo.UserBean;
import cn.chat.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String toIndexPage(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/login.action")
	public String findUserByUserName(String userName, String userPass, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Gender = null;
		String Phone = null;
		String Email = null;
		UserBean userBean = userService.findUserByUserName(userName, userPass);
		if (userName == null && userPass == null) {
			model.addAttribute("msg", "请输入账号密码:");
			return "login";
		} else {
			if (userBean != null) {
				System.out.println(userName + userPass);
				session.setAttribute("userBean", userBean);
				return "index";
			} else {
				model.addAttribute("msg", "账号或密码错误");
				return "login";
			}
		}
	}

	@RequestMapping(value = "/index.action")
	public String goIndex() {
		return "index";
	}

	@RequestMapping(value = "/register.action")
	public String addUser(UserBean userBean, BindingResult result, Model model, HttpServletRequest request,HttpSession session) {
		UserBean user = userService.findUserByName(userBean.getUserName());
		if (userBean.getUserName() != null) {
			if (user == null) {
				model.addAttribute("msg", "此用户名可以使用：");
				userService.addUser(userBean);
				
				session.setAttribute("userBean", userBean);
				return "index";
			} else {
				model.addAttribute("msg", "已存在用户名，请重新输入");
				return "register";
			}
		} else {
			return "register";
		}
	}

	@RequestMapping(value = "/updateinfo.action")
	public String update(String userName, String userPass, String phoneNumber, String email, Model model,
			HttpServletRequest request, HttpSession session) {
		UserBean user = (UserBean) session.getAttribute("userBean");
		System.out.println(userName + userPass + phoneNumber + email + user.getId());
		boolean flag = userService.update(userName, userPass, phoneNumber, email, user.getId());
		if (flag == true) {
			UserBean user1 = userService.findUserById(user.getId());
			request.setAttribute("user", user1);
			model.addAttribute("user", user1);
			return "login";
		} else {
			return "index";
		}
	}

	@RequestMapping(value = "/friendlist.action")
	public ModelAndView findAllUser(HttpSession session) {
		ModelAndView view = new ModelAndView();
		List<UserBean> list = userService.findAllUser();
		if (list != null) {
			view.addObject("list", list);
			for (UserBean user : list) {
				String userName = user.getUserName();
				String userPass = user.getUserPass();
				session.setAttribute("user", user);
			}
			view.setViewName("friendlist");
		} else {
			view.addObject("error", "msg");
		}
		return view;
	}
	@RequestMapping(value = "/personalinfo.action")
	public String personalinfo() {
		return "personalinfo";
	}
}
