package kr.co.mlec.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;


public class MemberController2 {
	
	@Autowired
	private MemberService service;

//	@RequestMapping(value ="/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {
		
		return "login/login";
	}
	@PostMapping("/login")
	public String loginProcess(MemberVO loginVO, HttpSession session) {
		
		MemberVO member = service.login(loginVO);
		if(member == null) {
			//로그인 실패
			return "redirect:/login";
		} else {
			//로그인 성공
			//세션저장
			session.setAttribute("userVO", member);
			
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}
