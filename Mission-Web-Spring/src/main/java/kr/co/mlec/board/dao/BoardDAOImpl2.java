package kr.co.mlec.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.board.vo.BoardVO;

/**
 * Mybatis를 이용한 CRUD
 * @author 15N530
 *
 */

@Repository
public class BoardDAOImpl2 implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = sqlSession.selectList("board.dao.BoardDAO.selectAll");
		return list;
	}

	@Override
	public BoardVO selectByNo(int no) {
		BoardVO board = sqlSession.selectOne("board.dao.BoardDAO.selectByNo",no);
		return board;
	}

	@Override
	public void insert(BoardVO board) {
		sqlSession.insert("board.dao.BoardDAO.insert",board);
	}

	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewCnt(int no) {
		sqlSession.update("board.dao.BoardDAO.viewCnt",no);
		
	}

}
