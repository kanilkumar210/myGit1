package com.pack.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.model.Corporate;
import com.pack.service.CorporateService;

@Controller
public class CorporateController {
	final static Logger logger = LogManager.getLogger(CorporateController.class);

	@Autowired
	CorporateService corporateService;

	@RequestMapping("/viewCorporates")
	public String viewCorporates(Model m) {
		logger.info("Inside viewCorporates method...");
		List<Corporate> list = corporateService.getAllRecords();
		m.addAttribute("corporateList", list);
		return "viewCorporates";
	}

	@RequestMapping("/deleteCorporate")
	public String deleteCorporate(@RequestParam("id") int id) {
		logger.info("Inside deleteCorporate method...");
		corporateService.deleteCorporate(id);
		return "redirect:/viewCorporates";
	}

	@RequestMapping("/editform")
	public String editForm(@RequestParam("id") int id, Model m) {
		logger.info("Inside editForm method...");
		Corporate obj = corporateService.getCorporate(id);
		m.addAttribute("corporateBean", obj);
		return "editform";
	}

	@RequestMapping("/editCorporate")
	public String editCorporate(@ModelAttribute("corporateBean") Corporate corporateBean) {
		logger.info("Inside editCorporate method...");
		corporateService.updateCorporate(corporateBean);
		return "redirect:/viewCorporates";
	}

	@RequestMapping("/adduserform")
	public String addCorporate(Model m) {
		logger.info("Inside addCorporate method...");
		m.addAttribute("corporateBean", new Corporate());
		return "corporateform";
	}

	@RequestMapping("/addCorporate")
	public String addCorporate(@ModelAttribute("corporateBean") Corporate corporateBean) {
		logger.info("Inside addCorporate method...");
		corporateService.addCorporate(corporateBean);
		return "redirect:/viewCorporates";
	}

}
