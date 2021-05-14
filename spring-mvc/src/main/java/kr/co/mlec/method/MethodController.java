package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/method/method.do")
public class MethodController {

	@GetMapping
//	@RequestMapping(method=RequestMethod.GET)
	public String callGEt() {
		return "method/methodForm";
	}
	
	@PostMapping
//	@RequestMapping(method=RequestMethod.POST)
	public String callPost() {
		return "method/methodProcess";
	}
}
