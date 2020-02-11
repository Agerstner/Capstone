//package com.claim_academy.capstone.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.claim_academy.capstone.WebUtils;
//import com.claim_academy.capstone.model.MaintenanceReports;
//import com.claim_academy.capstone.repository.MaintenanceRepository;
//import com.claim_academy.capstone.service.MaintenanceService;
//import com.claim_academy.capstone.validaiton.DataValidation;
//
//@Controller
//@SessionAttributes("loggedInUser")
//public class MaintenanceController {
//
//	private MaintenanceService maintenanceService;
//
//	private MaintenanceRepository maintenanceRepository;
//
//	private DataValidation dataValidation;
//
//	private WebUtils webUtils;
//
//	@Autowired
//	public MaintenanceController(MaintenanceService maintenanceService, MaintenanceRepository maintenanceRepository,
//			DataValidation dataValidation, WebUtils webUtils) {
//		super();
//		this.maintenanceService = maintenanceService;
//		this.maintenanceRepository = maintenanceRepository;
//		this.dataValidation = dataValidation;
//		this.webUtils = webUtils;
//	}
//
//	@GetMapping("requestMaintenance")
//	public String requestMaintenance(Model model) {
//
//		model.addAttribute("msg", "Request");
//		model.addAttribute("hidden", "");
//		model.addAttribute("user",);
//		model.addAttribute("request", new MaintenanceReports());
//		model.addAttribute("action", "submit");
//
//		return "requestMaintenance";
//
//	}
//
//	@PostMapping("requestMaintenance")
//	public String requestMaintenance(@ModelAttribute MaintenanceReports report, Model model, BindingResult result,
//			RedirectAttributes redirect) {
//
//		try {
//			dataValidation.validate(report, result);
//			if (result.hasErrors()) {
//				model.addAttribute("error", "Required* fields");
//				model.addAttribute("hidden", "");
//				model.addAttribute("action", "register");
//				return "requestMaintenance";
//			}
//
//			maintenanceService.save(report);
//			redirect.addFlashAttribute("success", "Maintenance request submited.");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//		}
//		return "redirect:/requestMaintenance";
//	}
//
//}
