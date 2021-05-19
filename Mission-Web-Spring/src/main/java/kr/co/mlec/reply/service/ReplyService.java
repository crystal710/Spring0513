package kr.co.mlec.reply.service;

import java.util.List;

import kr.co.mlec.reply.vo.ReplyVO;

public interface ReplyService {

	public void insertReply(ReplyVO replyVO);
	
	public List<ReplyVO> selectReplyByBoardNo(int boardNo);
}
