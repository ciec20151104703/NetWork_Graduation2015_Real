package com.lyh.springboot.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyh.springboot.pojo.Laboratory;
import com.lyh.springboot.pojo.Place;
import com.lyh.springboot.pojo.TemHum;
import com.lyh.springboot.pojo.User;
import com.lyh.springboot.service.LaboratoryService;
import com.lyh.springboot.service.PlaceService;
import com.lyh.springboot.service.TemHumService;
import com.lyh.springboot.service.LabUserService;
import com.lyh.springboot.service.UserService;

@Controller
@RequestMapping("config")
public class LaboratoryController {
	@Autowired
	UserService userService;
	@Autowired
	LabUserService labUserService;
	@Autowired
	LaboratoryService laboratoryService;
	@Autowired
	PlaceService placeService;
	@Autowired
	TemHumService temHumService;
	
	@RequestMapping("listLab")     //查询
	public String listLab(Model model) {
		List<Laboratory> lab = laboratoryService.list();
		model.addAttribute("lab", lab);
		Map<Laboratory, List<User>> lab_user = new HashMap<>();
		for (Laboratory laboratory : lab) {
			List<User> user = userService.listUser(laboratory);
			lab_user.put(laboratory, user);
		}
		model.addAttribute("lab_user", lab_user);

		return "labDetails";
	}
	
	@RequestMapping("listAll")     //查询
	public String listAll(Model model) {
		List<Laboratory> lab = laboratoryService.list();
		model.addAttribute("lab", lab);
		Map<Laboratory, List<User>> lab_user = new HashMap<>();
		for (Laboratory laboratory : lab) {
			List<User> user = userService.listUser(laboratory);
			lab_user.put(laboratory, user);
		}
		model.addAttribute("lab_user", lab_user);
		return "listLab";
	}
	
	@RequestMapping("listStu")     //查询
	public String listStu(Model model) {
		List<Laboratory> lab = laboratoryService.list();
		model.addAttribute("lab", lab);
		Map<Laboratory, List<User>> lab_user = new HashMap<>();
		for (Laboratory laboratory : lab) {
			List<User> user = userService.listStu(laboratory);
			lab_user.put(laboratory, user);
		}
		model.addAttribute("lab_user", lab_user);

		return "listLab";
	}
	
	@RequestMapping("listTeach")     //查询
	public String listTeach(Model model) {
		List<Laboratory> lab = laboratoryService.list();
		model.addAttribute("lab", lab);
		Map<Laboratory, List<User>> lab_user = new HashMap<>();
		for (Laboratory laboratory : lab) {
			List<User> user = userService.listTeacher(laboratory);
			lab_user.put(laboratory, user);
		}
		model.addAttribute("lab_user", lab_user);
		return "listLab";
	}

	@RequestMapping("editLab")    //修改
	public String edit(Model model, Integer lId) {
		Laboratory lab = laboratoryService.get(lId);
		model.addAttribute("lab", lab);
		List<User> us = userService.list();
		model.addAttribute("us", us);
		List<User> users = userService.listUser(lab);
		model.addAttribute("currentusers", users);		
		List<Place> places = placeService.listPlace();
		model.addAttribute("places", places);		
		Place place = placeService.selectPlace(lab);
		model.addAttribute("place", place);
		return "editLab";
	}
	
	@RequestMapping("addStu")    //修改
	public String editStu(Model model, Integer lId) {
		Laboratory lab = laboratoryService.get(lId);
		model.addAttribute("lab", lab);
		List<User> us = userService.listStu();
		model.addAttribute("us", us);
		List<User> users = userService.listStu2(lab);
		model.addAttribute("currentusers", users);
		model.addAttribute("type", "学生");
		return "editUserByLab";
	}
	
	@RequestMapping("addTeach")    //修改
	public String editTeach(Model model, Integer lId) {
		Laboratory lab = laboratoryService.get(lId);
		model.addAttribute("lab", lab);
		List<User> us = userService.listTeach();
		model.addAttribute("us", us);
		List<User> users = userService.listTeacher2(lab);
		model.addAttribute("currentusers", users);
		model.addAttribute("type", "教师");
		return "editUserByLab";
	}

	@RequestMapping("deleteLab")   //删除
	public String delete(Model model, Integer lId, HttpSession httpSession) {
		laboratoryService.delete(lId);
		List<Laboratory> labs = laboratoryService.findLab();
		httpSession.setAttribute("Lab", labs);
		return "redirect:listLab";
	}

	@RequestMapping("updateLab") 
	public String update(Laboratory lab, long[] userIds, String placeId, HttpSession httpSession) {	
		lab.setPlaceId(placeId);
		lab.setTemId(lab.getlId());
		labUserService.setUser(lab, userIds);
		laboratoryService.update(lab);
		List<Laboratory> labs = laboratoryService.findLab();
		httpSession.setAttribute("Lab", labs);
		return "redirect:listLab";
	}
	
	@RequestMapping("updateUserByLab") 
	public String updateUserByLab(Laboratory lab, long[] userIds, String TYPE, HttpSession httpSession) {	
		List<User> users;
		if(TYPE.equals("教师")) {
			users = userService.listStu2(lab);
		}else {
			users = userService.listTeacher2(lab);
		}
		labUserService.setUser2(lab, userIds, users);
		List<Laboratory> labs = laboratoryService.findLab();
		httpSession.setAttribute("Lab", labs);
		return "redirect:showLab?lId="+lab.getlId();
	}

	@RequestMapping("addLab")  //添加用户
	public String add(Model model, Laboratory lab, HttpSession httpSession) {
		laboratoryService.add(lab);
		return "redirect:listLab";
	}
	
	@RequestMapping("showLab")
	public String show(Model model, Laboratory l) {
		Laboratory lab = laboratoryService.get(l.getlId());
		model.addAttribute("lab", lab);
		List<User> stu = userService.listStu2(lab);
		List<User> teach = userService.listTeacher2(lab);
		model.addAttribute("lab_stu", stu);
		model.addAttribute("lab_teach", teach);
		Place place = placeService.selectPlace(lab);
		model.addAttribute("lab_place", place);
		TemHum th = temHumService.selectTemHum(lab);
		List<TemHum> ths = temHumService.selectByLab(lab);
		model.addAttribute("lab_th", th);
		model.addAttribute("lab_ths", ths);
		return "labShow";
	}
	
	@RequestMapping("/skinChange")
	public String skinChange(String color, HttpSession session){
		User user = (User) session.getAttribute("User");
		user.setColor(color);
		System.out.println(user.getId());
		System.out.println(user.getColor());
		userService.skinChange(user);
		User u = userService.findUserName(user.getNum());
		session.setAttribute("User", u);
		return "redirect:/menu";
	}
	
	
}
