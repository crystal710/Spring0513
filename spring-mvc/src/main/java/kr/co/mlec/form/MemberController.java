package kr.co.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class MemberController {

	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}
	
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo");
		mav.addObject("member", member);
		return mav;
	}
	
	/*
	@RequestMapping("/join.do")
	public String join(MemberVO member) {
		
		return "form/memberInfo";
	}
	
	
	/*
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member") MemberVO member) {
		
		System.out.println(member);
		
		return "form/memberInfo";
	}

	/*
	@RequestMapping("/join.do")
	public String join(HttpServletRequest request,
						@RequestParam("id") String id,
						@RequestParam("password") String password,
						@RequestParam("name") String name) {
		
	
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		/*request.setAttribute("id", id);
		request.setAttribute("password", password);
		request.setAttribute("name", name);*/
		/*
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}
*/


}
