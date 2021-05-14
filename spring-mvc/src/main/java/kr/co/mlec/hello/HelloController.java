package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello/hello.do") //해당 uri가 들어오면 hello() 메소드 실행 RequestMapping이용하여 메소드 호출
	public ModelAndView hello() {
		
		ModelAndView mav = new ModelAndView("hello/hello"); //공유영역의 객체등록과 포워드 시키려는 주소를 둘다 기억시키는 클래스 -> ModelAndView
		mav.addObject("msg","hi 스프링 MVC~~"); //dispatcher servlet이 자동으로 request영역에 올려줌
		return mav;
	}
}
