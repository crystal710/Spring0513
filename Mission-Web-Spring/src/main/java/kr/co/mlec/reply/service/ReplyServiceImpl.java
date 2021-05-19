package kr.co.mlec.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.reply.dao.ReplyDAO;
import kr.co.mlec.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public List<ReplyVO> selectReplyByBoardNo(int boardNo) {
		List<ReplyVO> list = replyDAO.selectAll(boardNo);
		return list;
	}
	
	@Override
	public void insertReply(ReplyVO replyVO) {
		
		replyDAO.insert(replyVO);
	}

}
