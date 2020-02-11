package com.claim_academy.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claim_academy.capstone.WebUtils;
import com.claim_academy.capstone.service.MaintenanceService;
import com.claim_academy.capstone.service.UserService;



@Controller
public class AppController {

	@Autowired
	private UserService userService;


	@Autowired
	WebUtils webUtils;

	@GetMapping({ "index", "/" })
	public String index(Model model) {
		model.addAttribute("msg", "Welcome to spring ");
		model.addAttribute("users", userService.findAll());
		return "index";
	}



	@GetMapping("about")
	// @ResponseBody()
	String about(Model model) {
		model.addAttribute("msg", "this is about us page");
		return "about";
	}

	@GetMapping("service")
	public String service(Model model) {
		model.addAttribute("msg", "Get in touch with us by filling");
		return "services";
	}

	@PostMapping("sendemail")
	public String sendemail(Model model, 
			@RequestParam String email, 
			@RequestParam String name,
			@RequestParam String subject,
			@RequestParam String message) {

		try {
			webUtils.sendMail("kennjuma16@gmail.com", message + " From " + name, subject);
			model.addAttribute("msg", "email sent");
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}
		return "services";
	}

	@GetMapping("name")
	public String name(@RequestParam int id, Model model) {
		model.addAttribute("msg", id);
		return "index";
	}

	@GetMapping("getname-{id}")
	public String getname(@PathVariable String id, Model model) {
		model.addAttribute("msg", id);
		return "index";
	}

	@PostMapping("whatisyouname")
	public String login(@RequestParam String lastname, 
						@RequestParam String firstname, Model model) {
		model.addAttribute("msg", "Last Name " + lastname + " first name " + firstname);

		return "index";
	}

}
