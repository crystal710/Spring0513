package kr.co.mlec.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.reply.service.ReplyService;
import kr.co.mlec.reply.vo.ReplyVO;

@RestController
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@PostMapping("/reply")
	public void addReply(ReplyVO replyVO) {
		service.insertReply(replyVO);
	}
	
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> replyAll(@PathVariable("boardNo") int boardNo) {
		List<ReplyVO> replyList = service.selectReplyByBoardNo(boardNo);
		return replyList;
	}
	
}
