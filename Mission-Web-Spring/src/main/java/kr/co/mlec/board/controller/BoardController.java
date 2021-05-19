package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.member.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/*
	 * http://localhost:9999/Mission-Web-Spring 호출시 index.jsp 연동
	 * 
	 */
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/board")
	public String list(HttpServletRequest request) {
		
		List<BoardVO> boardList = service.selectAllBoard();
		request.setAttribute("boardList", boardList);

		return "board/list";
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView boardByNo(@RequestParam("no") int no) {

		BoardVO board = service.detailBoard(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);//
		mav.setViewName("board/detail"); //forward 시키려는 주소값
		
		return mav;
	}
	
	@RequestMapping("/board/{no}")
	public ModelAndView boardByNo2(@PathVariable("no") int no) {
		BoardVO board = service.detailBoard(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		mav.setViewName("board/detail"); //forward 시키려는 주소값
		
		return mav;
	}
	
	@GetMapping("/board/write")
	public String writeForm(Model model, HttpSession session) {
		
		BoardVO board =new BoardVO();
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		board.setWriter(userVO.getId());
		model.addAttribute("boardVO", board);
		
		return "board/write";
	}
	
	@PostMapping("/board/write")
	public String write(@Valid BoardVO board, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("오류발생...");
			return "board/write";
		}
		
		service.insertBoard(board);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/board/delete/{no}")
	public String deleteByNo(@PathVariable("no") int no) {
		service.deleteBoard(no);
		
		return "redirect:/board";
		
	}
}
