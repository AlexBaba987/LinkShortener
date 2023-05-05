package com.ak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ak.binding.CreateNewUserBinding;
import com.ak.binding.UnlockBinding;
import com.ak.binding.UserLoginBinding;
import com.ak.service.ICreateNewUserService;

@Controller
public class LoginController {
	
	@Autowired
	private ICreateNewUserService userService;
	
	@GetMapping("/login")
	public String showLoginPage(@ModelAttribute("user") UserLoginBinding userLogin) {
		return "login";
	}
	
	@GetMapping("/createNewUser")
	public String showCreateNewUser(Model model) {
		model.addAttribute("newuser",new CreateNewUserBinding());
		return "newuser";
	}
	
	@PostMapping("/createNewUser")
	public String saveNewUser(@ModelAttribute("newuser") CreateNewUserBinding newUser,Model model) {
		boolean msg=userService.saveNewUser(newUser);
		
		if(msg)
			model.addAttribute("successMsg", "Check you Mail");
		else
			model.addAttribute("errMsg","problem occur");
		
		return "newuser";
	}
	
	@GetMapping("/unlock")
	public String getUnlockPage(@ModelAttribute("lock") UnlockBinding obj,@RequestParam("email") String email1,Model model) {
		obj.setEmail(email1);
		
		model.addAttribute("email",obj);
		return "unlock";
	}

}
