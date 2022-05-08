package com.pack.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.model.Corporate;
import com.pack.model.User;
import com.pack.service.CorporateService;
import com.pack.service.UserService;

//Anil
@Controller
public class UserController {

	final static Logger logger = LogManager.getLogger(CorporateController.class);

	@Autowired
	UserService userService;

	@Autowired
	CorporateService corService;

	@RequestMapping("/")
	public String indexPage() {
		logger.info("Inside indexPage method...");
		return "index";
	}

	@RequestMapping("/adminHomePage")
	public String adminHomePage() {
		logger.info("Inside adminHomePage method...");
		return "adminHome";
	}

	@RequestMapping("/logout")
	public String logout() {
		logger.info("Inside logout method...");
		return "redirect:/";
	}

	@RequestMapping("/adminHome")
	public String adminHome() {
		logger.info("Inside adminHome method...");
		return "adminHome";
	}

	@RequestMapping("/getUsers")
	public String getUsers() {
		logger.info("Inside getUsers method...");
		return "getUsers";
	}

	@RequestMapping("/userList")
	public String userList(@RequestParam("id") String id, Model m) {
		logger.info("Inside userList method...");
		m.addAttribute("id", id);
		return "userList";
	}

	@RequestMapping("/registerUser")
	public String registerUser(Model m) {
		logger.info("Inside registerUser method...");
		m.addAttribute("userBean", new User());
		return "registerUser";
	}

	@RequestMapping("/addUserDetails")
	public String addUserDetails(@ModelAttribute("userBean") User userBean, Model m) {
		logger.info("Inside addUserDetails method...");
		User user = userService.addUserDetails(userBean);
		Corporate name = corService.getCorporate(userBean.getCorporate().Corporate_id);
		if (user == null) {
			m.addAttribute("message", "***Please Provide Correct Information....!!!!");
			return "registerUser";
		} else {
			return "redirect:/userList?id=" + name.getCorporateName();
		}
	}

	@RequestMapping("/updateUserDetails")
	public String updateUserDetails(@RequestParam("id") long id, @RequestParam("corId") long corId, Model m) {
		logger.info("Inside updateUserDetails method...");
		User user = userService.getUser(id);
		System.out.println(user);
		m.addAttribute("userBean", user);
		return "updateUserDetails";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("userBean") User userBean) {
		logger.info("Inside updateUser method...");
		userService.updateUser(userBean);
		Corporate name = corService.getCorporate(userBean.getCorporate().Corporate_id);
		return "redirect:/userList?id=" + name.getCorporateName();
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") long id, @RequestParam("corId") long corId) {
		logger.info("Inside deleteUser method...");
		userService.deleteUser(id);
		Corporate name = corService.getCorporate(corId);
		return "redirect:/userList?id=" + name.getCorporateName();
	}

}
