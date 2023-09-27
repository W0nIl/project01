package com.team2.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team2.service.MemberService;
import com.team2.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	//security
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	@GetMapping("/register")
	public void getRegister() throws Exception {
		System.out.println("Register getRegister");
		logger.info("get register");
	}
	
	// 회원가입 post
	@PostMapping("/register")
	public String postRegister(MemberVo vo) throws Exception {
		logger.info("post register");
		System.out.println("Register postRegister");
		int result = service.idChk(vo);
		
		try {
			if(result == 1) {
				return "/register";
			}else if(result == 0) {
				String inputPass = vo.getU_pw();
				String pwd = pwdEncoder.encode(inputPass);
				vo.setU_pw(pwd);
				service.register(vo);
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
		return "redirect:/";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@PostMapping("/idChk")
	public int idChk(MemberVo vo) throws Exception{
		System.out.println("Controller IdChk");
		int result = service.idChk(vo);
		return result;
	}
	
	//로그인
	@PostMapping("/login")
	public String login(MemberVo vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		System.out.println("Controller Login");
		
		session.getAttribute("member");
		MemberVo login = service.login(vo);
		boolean pwdMatch = pwdEncoder.matches(vo.getU_pw(), login.getU_pw());
		
		if(login != null && pwdMatch == true) {
			session.setAttribute("member", login);
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg",false);
		}
		
		return "redirect:/";
		
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		System.out.println("Controller logout");
		session.invalidate();
		return "redirect:/";
	}
	
	//비밀번호 체크
	@ResponseBody
	@PostMapping("/passChk")
	public boolean passChk(MemberVo vo) throws Exception{
		
		MemberVo login = service.login(vo);
		boolean pwdChk = pwdEncoder.matches(vo.getU_pw(), login.getU_pw());
		return pwdChk;
	}
}
