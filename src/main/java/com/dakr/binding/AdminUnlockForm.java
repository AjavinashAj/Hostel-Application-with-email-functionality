package com.dakr.binding;

import lombok.Data;

@Data
public class AdminUnlockForm {
	
	private String email;

	private String tempPwd;

	private String newPwd;

	private String confirmPwd;


}
