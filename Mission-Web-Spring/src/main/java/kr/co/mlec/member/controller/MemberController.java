package kr.co.mlec.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;

@SessionAttributes({"userVO"})
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

//	@RequestMapping(value ="/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {
		
		return "login/login";
	}
	@PostMapping("/login")
	public ModelAndView loginProcess(MemberVO loginVO) {
		
		MemberVO member = service.login(loginVO);
		
		ModelAndView mav = new ModelAndView();
		if(member==null) {
			mav.setViewName("redirect:/login");
		}else {
			mav.setViewName("redirect:/");
			mav.addObject("userVO",member);
		}
		
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/";
	}
	
	@RequestMapping("/member")
	public String list(HttpServletRequest request) {
		
		List<MemberVO> memberList = service.selectAllMember();
		request.setAttribute("memberList", memberList);
		
		return "member/memberList";
		
	}
	
	@GetMapping("/member/insert")
	public String memberForm(Model model) {
		MemberVO member = new MemberVO();
		model.addAttribute("MemberVO", member);
		
		return "member/memberInsert";
	}
	
	
}
