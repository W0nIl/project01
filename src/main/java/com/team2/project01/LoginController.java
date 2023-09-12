package com.team2.project01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public void login() {
		System.out.println("로그인 구현");
	}

}
