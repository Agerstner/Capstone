package com.claim_academy.capstone.validaiton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.claim_academy.capstone.model.MaintenanceReports;
import com.claim_academy.capstone.repository.MaintenanceRepository;
import com.claim_academy.capstone.model.Users;
import com.claim_academy.capstone.repository.UserRepository;



@Component
public class DataValidation implements Validator {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired 
	public MaintenanceRepository maintenanceRepository;
	
	String emailRegex ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	String phoneRegex ="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
			
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}

	public void validate(Object o, Errors errors) {
		Users user = (Users) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");		
		if (userRepository.findByEmail(user.getEmail()) !=null) {
	    	errors.rejectValue("email", "size.user.unique");
	    }
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() <=0  ||  user.getPassword().length() < 4) {
	    	errors.rejectValue("password", "size.user.password");
	    }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatepass", "NotEmpty");
        if (!user.getRepeatepass().equals(user.getPassword())) {
	    	errors.rejectValue("repeatepass", "match.user.repeatepass");
	    }
        
        if (!user.getEmail().matches(emailRegex)) {
        	errors.rejectValue("email", "size.user.email");
	    }
        
        if (!user.getPhone().matches(phoneRegex)) {
        	errors.rejectValue("phone", "size.user.phone");
	    }
		
	}
	
	public void validateUpdate(Object o, Errors errors) {
		Users user = (Users) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() <=0  ||  user.getPassword().length() < 4) {
	    	errors.rejectValue("password", "size.user.password");
	    }
        
        if (!user.getPhone().matches(phoneRegex)) {
        	errors.rejectValue("phone", "size.user.phone");
	    }
	}
	
	public void validateReport(Object o, Errors errors) {
		MaintenanceReports report = (MaintenanceReports) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "report.notEmpty");
		if(report.getDetails().length()<10) {
			errors.rejectValue("descpription", "report.notEmpty");
		}
		
	}
}