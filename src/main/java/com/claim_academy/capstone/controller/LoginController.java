package com.claim_academy.capstone.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claim_academy.capstone.WebUtils;
import com.claim_academy.capstone.model.Users;
import com.claim_academy.capstone.repository.MaintenanceRepository;
import com.claim_academy.capstone.repository.UserRepository;
import com.claim_academy.capstone.service.UserService;
import com.claim_academy.capstone.model.MaintenanceReports;
import com.claim_academy.capstone.service.MaintenanceService;
import com.claim_academy.capstone.validaiton.DataValidation;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController {

	private UserRepository userRepository;

	private UserService userService;

	private MaintenanceService maintenanceService;

	private MaintenanceRepository maintenanceRepository;

	private DataValidation dataValidation;

	private WebUtils webUtils;

	//private LocalDateTime dateTime = LocalDateTime.now();

	@Autowired
	public LoginController(UserService userService, UserRepository userRepository,
			MaintenanceService maintenanceService, MaintenanceRepository maintenanceRepository,
			DataValidation dataValidation, WebUtils webUtils) {
		super();
		this.userRepository = userRepository;
		this.userService = userService;
		this.maintenanceService = maintenanceService;
		this.maintenanceRepository = maintenanceRepository;
		this.dataValidation = dataValidation;
		this.webUtils = webUtils;
		// this.reportService = reportService;ff
	}

	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("msg", "Login");
		return "login";
	}

	@GetMapping("profile")
	public String profile(Model model) {
		model.addAttribute("msg", "Welcome back");
		return "profile";
	}

	@PostMapping("login")
	public String signin(@RequestParam String email, @RequestParam String password, Model model) {
		try {
			Users user = userService.findByEmail(email).get();
			if (user != null && password.equals(user.getPassword())) {
				model.addAttribute("msg", "Welcome " + email);
				model.addAttribute("loggedInUser", user);
			} else {
				model.addAttribute("error", "Invalid Credentials");
				return "login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "profile";
	}

	@PostMapping("search")
	public String search(@RequestParam String name, Model model) {

		model.addAttribute("msg", userService.findByLastname(name).size() + " user(s) found");
		model.addAttribute("users", userService.findByLastname(name));

		return "users";
	}

	@GetMapping("users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@GetMapping("reports")
	public String reports(Model model) {
		model.addAttribute("reports", maintenanceService.findAll());
		return "reports";
	}

	@GetMapping("register")
	public String register(Model model) {

		model.addAttribute("msg", "Register");
		model.addAttribute("hidden", "");
		model.addAttribute("users", new Users());
		model.addAttribute("action", "register");

		return "register";
	}

	@PostMapping("register")
	public String register(@ModelAttribute Users user, Model model, BindingResult result, RedirectAttributes redirect) {

		try {
			dataValidation.validate(user, result);
			if (result.hasErrors()) {
				model.addAttribute("error", "Required* fields");
				model.addAttribute("hidden", "");
				model.addAttribute("action", "register");
				return "register";
			}
			user.setRole("USER");
			userService.save(user);
			redirect.addFlashAttribute("success", "User " + user.getFirstname() + " saved");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return "redirect:/login";
		// return "redirect:/users";
	}

	@GetMapping("reportPage")
	public String reportPage(@RequestParam long id, Model model) {

		try {
			model.addAttribute("reports", maintenanceService.findById(id).get());
			webUtils.getFiles(model, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return "reportDetails";
	}
	
//	@GetMapping("reportDetails")
//	public String reportDetails(@RequestParam long id, Model model) {
//		
//		model.addAttribute("", );
//		
//		return "reportDetails";
//	}
	
	@GetMapping("maintenanceRequests")
	public String maintenanceRequests(Model model) {
		model.addAttribute("reports", maintenanceService.findAll());
		return "maintenanceRequests";
	}

	@GetMapping("requestMaintenance")
	public String requestMaintenance(@ModelAttribute MaintenanceReports maintenanceReport, Model model,
			RedirectAttributes redirect) {
		
		
		model.addAttribute("msg", "Request Maintenance");
		model.addAttribute("hidden", "");
		model.addAttribute("reports", new MaintenanceReports());
		model.addAttribute("action", "requestMaintenance");
	

		return "requestMaintenance";

	}

	@PostMapping("requestMaintenance")
	public String requestMaintenance(@ModelAttribute MaintenanceReports maintenanceReport, Model model,
		BindingResult result, RedirectAttributes redirect) {
		
		maintenanceService.save(maintenanceReport);
		model.addAttribute("hidden", "");
		model.addAttribute("action", "requestMaintenance");
		
		
		redirect.addFlashAttribute("success", "Maintenance request submited.");
		return "redirect:/profile";
	}

	@GetMapping("delete")
	public String deleteuser(@RequestParam long id, RedirectAttributes redirect) {

		userService.delete(id);
		redirect.addFlashAttribute("success", "Delete Success");
		return "redirect:/users";
	}
	

	@GetMapping("update")
	public String update(@RequestParam long id, Model model) {
		model.addAttribute("msg", "Update");
		model.addAttribute("users", userService.findById(id).get());
		model.addAttribute("hidden", "hidden");
		model.addAttribute("action", "updateUser");
		return "register";
	}

	@PostMapping("updateUser")
	public String update(@ModelAttribute Users user, RedirectAttributes model, Model mod, BindingResult result) {
		dataValidation.validateUpdate(user, result);
		if (result.hasErrors()) {
			mod.addAttribute("error", "Required* fields");
			mod.addAttribute("hidden", "hidden");
			mod.addAttribute("action", "updateUser");
			return "register";
		}
		try {
			userService.update(user);
			model.addFlashAttribute("success", "User " + user.getFirstname() + " Updated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return "redirect:/users";
	}

	@PostMapping("editprofile")
	public String editprofile(@ModelAttribute("user") Users user, Model model) {

		try {

			Users usr = userService.findByEmail(user.getEmail()).get();
			usr.setFirstname(user.getFirstname());
			usr.setLastname(user.getLastname());
			usr.setPhone(user.getPhone());
			userService.save(usr);
			model.addAttribute("loggedInUser", userService.findByEmail(user.getEmail()).get());

			model.addAttribute("success", " Updated success");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return "profile";
	}

	@GetMapping("logout")
	public String logout(Model model, WebRequest request, SessionStatus status) {
		status.setComplete();
		request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
		model.addAttribute("success", "You have been signed out");
		return "login";
	}

	@PostMapping("editrole")
	public String giverole(RedirectAttributes model, @RequestParam long id, @RequestParam String role) {
		Users user = userService.findById(id).get();
		if (user != null) {
			user.setRole(role);
			userService.save(user);
			model.addFlashAttribute("msg",
					user.getFirstname() + " " + user.getLastname() + " has been assigned the role of " + role);
		}
		return "redirect:/users";
	}

	@PostMapping("resetcode")
	public String resetcode(Model model, @RequestParam String email) {
		Users user = userService.findByEmail(email).get();
		if (user != null) {
			// user.setCode(code);
			userService.save(user);
			webUtils.sendMail(email, "Please use this code" + 888 + " to reset password", "Password Reset");
			model.addAttribute("msg", "Check you email for seset instruction");
		}
		return "resetpass";
	}

	@GetMapping("userprofile")
	public String userprofiles(@RequestParam long id, Model model) {

		try {
			model.addAttribute("profiles", userService.findById(id).get());
			webUtils.getFiles(model, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return "userprofiles";
	}

	@PostMapping("dropaline")
	public String dropaline(@RequestParam String to, @RequestParam String from, @RequestParam String fromname,
			@RequestParam String message, RedirectAttributes model) {

		try {
			String msg = message + " Thanks. From " + fromname + " " + from;
			webUtils.sendMail(to, msg, "Hi Message");
			model.addFlashAttribute("msg", "Email sent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return "redirect:/users";
	}

	
	
	@ModelAttribute("profile")
	Users profile() {
		return new Users();

	}

	
	
	
}
