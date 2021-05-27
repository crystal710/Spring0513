package kr.co.mlec.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@GetMapping("/register")
	public String memberRegister(Model model) {
		MemberVO member = new MemberVO();
		model.addAttribute("MemberVO", member);
		
		return "member/memberRegister";
	}
	
	@PostMapping("/register")
	public String memberRegister(@Valid MemberVO member, BindingResult result) {
		if(result.hasErrors()) {
			return "member/memberRegister";
		}
		
		service.insertMember(member);
		
		return "redirect:/";
	}
	
	  // 회원가입 post

		/*
		 * @RequestMapping(value = "/register", method = RequestMethod.POST)
		 * 
		 * public String postRegister(MemberVO vo) throws Exception {
		 * 
		 * logger.info("post register");
		 * 
		 * int result = service.idChk(vo);
		 * 
		 * try {
		 * 
		 * if(result == 1) {
		 * 
		 * return "/member/register";
		 * 
		 * }else if(result == 0) {
		 * 
		 * service.register(vo);
		 * 
		 * }
		 * 
		 * // 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기
		 * 
		 * // 존재하지 않는다면 -> register
		 * 
		 * } catch (Exception e) {
		 * 
		 * throw new RuntimeException();
		 * 
		 * }
		 * 
		 * return "redirect:/";
		 * 
		 * }
		 */
	
	
}
