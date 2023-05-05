package com.ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.binding.CreateNewUserBinding;
import com.ak.entity.CreateNewUserEntity;
import com.ak.helper.GenerateRandomPassword;
import com.ak.helper.MailSenderClass;
import com.ak.repository.ICreateNewUserRepository;

@Service
public class CreateNewUserServiceImpl implements ICreateNewUserService {
	
	@Autowired
	private ICreateNewUserRepository userRepo;
	
	@Autowired
	private MailSenderClass emailSender;

	@Override
	public boolean saveNewUser(CreateNewUserBinding newUser) {
		//temporary password
		String tempPwd=GenerateRandomPassword.pwd();
		
		//prepare Entity class object
		CreateNewUserEntity user=new CreateNewUserEntity();
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPhno(Long.valueOf(newUser.getPhno()));
		user.setPwd(tempPwd);
		user.setAcc_status("Locked");
		
		//save object
		userRepo.save(user);
		
		//send mail
		String to=newUser.getEmail();
		String subject="unlock your account";
		
		StringBuffer body=new StringBuffer("");
		body.append("<h1>Use Below Temporary Password to Unlock Your Account.</h1>");
		body.append("Temporary Password : "+tempPwd);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8855/Mini-Project-02-Enquiry_Portal-3/unlock?email="+to+"\">Cleck Here to Unlock Your Account</a>");
		
		boolean result=emailSender.sendEmail(to, subject, body.toString());
		
		return result;
	}

}
