package com.dakr.service;

import com.dakr.binding.StudentLoginForm;
import com.dakr.binding.StudentRegistrationBinding;
import com.dakr.binding.StudentUnlockForm;

public interface StudentService {

	boolean signUp(StudentRegistrationBinding form);

	boolean unlockFormAccount(StudentUnlockForm form);

	public String loginForm(StudentLoginForm form);

	public boolean forgotPwd(String email);

}
