package com.ak.binding;

import lombok.Data;

@Data
public class UnlockBinding {

	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	
}
