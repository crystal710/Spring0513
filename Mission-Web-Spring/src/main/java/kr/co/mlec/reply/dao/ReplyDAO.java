package kr.co.mlec.reply.dao;

import java.util.List;

import kr.co.mlec.reply.vo.ReplyVO;

public interface ReplyDAO {
	
	public void insert(ReplyVO replyVO);
	
	public List<ReplyVO> selectAll(int boardNo);

}
