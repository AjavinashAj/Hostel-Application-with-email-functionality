package com.dakr.service;

import com.dakr.binding.AdminRegistrationBinding;
import com.dakr.binding.AdminUnlockForm;
import com.dakr.binding.StudentLoginForm;

public interface AdminService {

	public boolean signUp(AdminRegistrationBinding form);

	public boolean unlockFormAccount(AdminUnlockForm form);

	public String loginForm(StudentLoginForm form);

	public boolean forgotPwd(String email);

}
