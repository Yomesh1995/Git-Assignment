package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(Model m) {
		m.addAttribute("emp", new Employee());
		return "index";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("emp") Employee emp, BindingResult br, Model m) {
		if (br.hasErrors()) {
			return "index";
		} else {
			m.addAttribute("msg", "Submit Valid");
			return "success";
		}
	}
}
