package com.ak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="AIT_USER_DETAILS")
public class CreateNewUserEntity {

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="USER_PHONE_NUMBER")
	private Long phno;
	
	@Column(name="USER_PASSWORD")
	private String pwd;
	
	@Column(name="USER_ACC_STATUS")
	private String acc_status;
}
