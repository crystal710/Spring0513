package kr.co.mlec.board.service;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardService {

	/**
	 * 전체게시글 조회
	 */
	public List<BoardVO> selectAllBoard();
	
	/**
	 * 상세게시글 조회
	 */
	public BoardVO detailBoard(int no);
}
