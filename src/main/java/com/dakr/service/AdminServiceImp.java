package com.dakr.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.binding.AdminRegistrationBinding;
import com.dakr.binding.AdminUnlockForm;
import com.dakr.binding.StudentLoginForm;
import com.dakr.entity.AdminRegistration;
import com.dakr.entity.StudentRegistration;
import com.dakr.repository.AdminRegistrationRepository;
import com.dakr.utils.EmailUtils;
import com.dakr.utils.PwdUtils;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private final EmailUtils emailUtil;
	@Autowired
	private final PwdUtils pwdUtil;
	@Autowired
	private final AdminRegistrationRepository repo;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean signUp(AdminRegistrationBinding form) {
		AdminRegistration findByEmail = repo.findByEmail(form.getEmail());
		if (findByEmail != null) {
			return false;
		}
		// TODO: Copy data to binding object to entity obj
		AdminRegistration entity = new AdminRegistration();
		BeanUtils.copyProperties(form, entity);
		// TODO: generate random pwd and set to object
		String tempPwd = pwdUtil.generateRandomPassword();
		entity.setPassword(tempPwd);
		// TODO: set Account Status as LOCKED
		entity.setAccStatus("LOCKED");
		// TODO: Insert Record
		repo.save(entity);
		// TODO: send email to unlock the account
		String to = form.getEmail();
		String subject = "<h1>User below Temporary password to unlock your Account</h1>";
		StringBuffer body = new StringBuffer("");
		body.append("<h1>Use Below Temporary Passworld To Unlock Your Account</h1>");
		body.append("Temporary PWD :" + tempPwd);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:9090/unlock?email=" + to + "\">Click Here to Unlock Your Account");
		emailUtil.sendEmail(to, subject, body.toString());
		return true;
		
		
	}

	@Override
	public boolean unlockFormAccount(AdminUnlockForm form) {
		AdminRegistration entity = repo.findByEmail(form.getEmail());
		if (entity.getPassword().equals(form.getTempPwd())) {
			entity.setPassword(form.getNewPwd());
			entity.setAccStatus("Unlocked");
			repo.save(entity);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String loginForm(StudentLoginForm form) {
		AdminRegistration entity = repo.findByEmailAndPassword(form.getEmail(), form.getPwd());
		if (entity == null) {
			return "Invalid Credential";
		}
		if (entity.getAccStatus().equals("LOCKED")) {
			return "Your Account is Locked...";
		}
		//create session and store user data in session
		session.setAttribute("userId", entity.getAdminId());
		return "success";
	}

	@Override
	public boolean forgotPwd(String email) {
		// check Record Presence in db with given mail
		AdminRegistration entity = repo.findByEmail(email);

		// if record not available sent msg
		if (entity == null) {
			return false;
		}

		// if record available in db sent password and sent success msg
		String subject = "<h1>Recover Password<h1>";
		String body = "Your Pwd :: " + entity.getPassword();

		emailUtil.sendEmail(email, subject, body);

		return true;

	}

}
