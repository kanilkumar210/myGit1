package com.pack.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.exception.NoAccountsPresentException;
import com.pack.model.Account;
import com.pack.model.Corporate;
import com.pack.model.User;
import com.pack.service.AccountService;
import com.pack.service.CorporateService;
import com.pack.service.UserDetailsServiceImpl;
import com.pack.service.UserService;

@Controller
public class AccountController {

	final static Logger logger = LogManager.getLogger(AccountController.class);

	@Autowired
	AccountService accountService;

	@Autowired
	UserService userService;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	CorporateService corService;

	User user = null;

	@RequestMapping("/accountSummary")
	public String getAccounts(Model m) {
		logger.info("Inside getAccounts method...");
		this.user = userDetailsService.getUser();
		if (user.getStatus().equalsIgnoreCase("F") & user.isActive() == true) {
			m.addAttribute("userBean", user);
			return "resetpassword";
		}
		List<Account> accList = accountService.getAccounts(user.getCorporate().getCorporate_id());
		try {
			if (accList.isEmpty()) {
				throw new NoAccountsPresentException();
			}
		} catch (NoAccountsPresentException e) {
			logger.info("NoAccountsPresentException in getAccounts method...");
			m.addAttribute("exception", e);
			return "accountsummary";
		}
		m.addAttribute("accList", accList);
		return "accountsummary";
	}

	@GetMapping("/accountDetails")
	public String accountDetails(@RequestParam("id") long id, Model m) {

		logger.info("Inside accountDetails method...");
		try {
			if (id == 0) {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			m.addAttribute("exception", "***Please Select Any Account In The Acccount Summary.....");
			return "ExceptionPage";
		}
		Account acc = accountService.getAccount(id);
		m.addAttribute("acc", acc);
		return "accountDetails";
	}

	@RequestMapping("/addResetPassword")
	public String addResetPassword(@RequestParam("pass") String pass, @RequestParam("confirmPass") String confirmPass,
			Model m) {
		logger.info("Inside addResetPassword method...");
		User userObj = userService.resetPassword(pass, confirmPass, user.getLogin_id());
		m.addAttribute("user", userObj);
		return "redirect:/userHome?Corporate_id=" + userObj.getCorporate().Corporate_id;
	}

	@RequestMapping("/userHome")
	public String userHome(@RequestParam("Corporate_id") long Corporate_id, Model m) {
		logger.info("Inside userHome method...");
		List<Account> accList = accountService.getAccounts(Corporate_id);
		try {
			if (accList.isEmpty()) {
				throw new NoAccountsPresentException();
			}
		} catch (NoAccountsPresentException e) {
			logger.info("NoAccountsPresentException in getAccounts method...");
			m.addAttribute("exception", e);
			return "accountsummary";
		}
		m.addAttribute("message", "****Reset Password Successfully Completed....!!!");
		m.addAttribute("accList", accList);
		return "accountsummary";

	}

	@RequestMapping("/getAccountDetails")
	public String getAccountDetails() {
		logger.info("Inside getAccountDetails method...");
		return "getAccountDetails";
	}

	@RequestMapping("/getAccounts")
	public String getAccounts(@RequestParam("id") String id, Model m) {
		logger.info("Inside getAccounts method...");
		m.addAttribute("id", id);
		return "getAccounts";
	}

	@RequestMapping("/addaccform")
	public String addAccForm(Model m) {
		logger.info("Inside addAccForm method...");
		m.addAttribute("accBean", new Account());
		return "AccountForm";
	}

	@RequestMapping("/addAccount")
	public String addAccount(@ModelAttribute("accBean") Account accBean) {
		logger.info("Inside addAccount method...");
		accountService.addAccount(accBean);
		Corporate name = corService.getCorporate(accBean.getCorporate().Corporate_id);
//		m.addAttribute("id", name.getCorporateName());
		return "redirect:/getAccounts?id=" + name.getCorporateName();
	}

	@RequestMapping("/closeAccount")
	public String closeAccount(@RequestParam("id") long id, @RequestParam("corname") String corname, Model m) {
		logger.info("Inside closeAccount method...");
		accountService.closeAccount(id);
		m.addAttribute("id", corname);
		return "getAccounts";
	}

}
