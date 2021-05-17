package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;

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
}
