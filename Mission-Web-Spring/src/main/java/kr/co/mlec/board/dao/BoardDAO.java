package kr.co.mlec.board.dao;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardDAO {

	/**
	 * 전체게시글 조회서비스
	 */
	public List<BoardVO> selectAll();
		
	
	/**
	 * 게시글 상세 조회서비스
	 */
	public BoardVO selectByNo(int no);
	
	/**
	 * 새글 등록 서비스
	 */
	public void insert(BoardVO board);
	
	/**
	 * 게시글 수정 서비스
	 */
	public void update(BoardVO board);
	
	/**
	 * 게시글 삭제 서비스
	 */
	public void delete(int no);
	
	/**
	 * 조회수 증가
	 */
	public void updateViewCnt(int no);
}
