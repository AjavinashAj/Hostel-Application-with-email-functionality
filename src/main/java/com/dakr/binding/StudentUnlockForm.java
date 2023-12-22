package com.dakr.binding;

import lombok.Data;

@Data
public class StudentUnlockForm {

	
	private String email;

	private String tempPwd;

	private String newPwd;

	private String confirmPwd;

}
