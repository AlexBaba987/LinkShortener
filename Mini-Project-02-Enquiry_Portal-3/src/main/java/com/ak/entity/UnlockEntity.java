package com.ak.entity;

import lombok.Data;

@Data
public class UnlockEntity {

	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	
}
