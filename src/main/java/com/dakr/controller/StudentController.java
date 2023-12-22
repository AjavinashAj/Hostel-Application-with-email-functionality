package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.binding.StudentLoginForm;
import com.dakr.binding.StudentRegistrationBinding;
import com.dakr.binding.StudentUnlockForm;
import com.dakr.service.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class StudentController {
	
	@Autowired
	private final StudentService service;
	
	//for registration
	
	@PostMapping("/stsign")
	public String handleSignUp(@RequestBody StudentRegistrationBinding form) {
		
		String temp="";
		
		boolean status = service.signUp(form);
		
		if (status) {
			temp= "Account Created: Check Your Email";
		} else {
			temp= "Choose Unique Email";
		}
		
		return temp;
	}
	
	// for unlock
	
	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email) {
		
		StudentUnlockForm unlockForm = new StudentUnlockForm();
		
		unlockForm.setEmail(email);
		
		
		return "unlock";
	}

	@PostMapping("/unlock")
	public String unlockUserAccount(@RequestBody StudentUnlockForm form) {
		
		String temp="";
		
		if (form.getNewPwd().equals(form.getConfirmPwd())) {
			
			boolean status = service.unlockFormAccount(form);
			
			if (status) {
				 temp="Your Account Unlocked Successfully..";
			} else {
				temp="Given Temporary PWD is Wrong, Check Your mail.";
			}
		} else {
			temp= "New PWD and conform PWD is should be same.";
		}
		
		return temp;
	}
	
	
	//LOGIN
	
		@GetMapping("/login")
		public String loginPage(Model model) {
			
			model.addAttribute("loginForm", new StudentLoginForm());
			
			return "login";
		}

		@PostMapping("/login")
		public String login(@RequestBody StudentLoginForm form) {
			String temp="";
			String status = service.loginForm(form);
			
			if (status.contains("success")) {
				temp="login successfull";
			}
			
			
			
			return temp;
		}
		
		
		// forgot password
		
		@GetMapping("/forgot")
		public String forgetPwd() {
			return "forgot";
		}

		@PostMapping("/forgotPwd")
		public String forgotPwdPage(@RequestParam("email") String email) {
	        String temp="";
			boolean status = service.forgotPwd(email);

			if (status) {
				temp= "Your Password sent your mail";
			} else {
				temp="Invalid Email";
			}

			return temp;
		}


}
