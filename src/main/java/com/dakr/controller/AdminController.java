package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.binding.AdminLoginForm;
import com.dakr.binding.AdminRegistrationBinding;
import com.dakr.binding.AdminUnlockForm;
import com.dakr.binding.StudentLoginForm;
import com.dakr.service.AdminService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class AdminController {
	
	@Autowired
	private final AdminService service;
	
	//for registration
	
		@PostMapping("/adsign")
		public String handleSignUp(@RequestBody AdminRegistrationBinding form) {
			
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
		
		@GetMapping("/adunlock")
		public String unlockPage(@RequestParam String email) {
			
			AdminUnlockForm unlockForm = new AdminUnlockForm();
			
			unlockForm.setEmail(email);
			
			
			return "unlock";
		}

		@PostMapping("/adunlock")
		public String unlockUserAccount(@RequestBody AdminUnlockForm form) {
			
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
		
			@GetMapping("/adlogin")
			public String loginPage(Model model) {
				
				model.addAttribute("loginForm", new AdminLoginForm());
				
				return "login";
			}

			@PostMapping("/adlogin")
			public String login(@RequestBody StudentLoginForm form) {
				String temp="";
				String status = service.loginForm(form);
				
				if (status.contains("success")) {
					temp="login successfull";
				}
				
				
				
				return temp;
			}
			
			

			// forgot password
			
			@GetMapping("/adforgot")
			public String forgetPwd() {
				return "forgot";
			}

			@PostMapping("/adforgotPwd")
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
