package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name) {
		System.out.println("Name : " + name);
		return "login";
	}

}
