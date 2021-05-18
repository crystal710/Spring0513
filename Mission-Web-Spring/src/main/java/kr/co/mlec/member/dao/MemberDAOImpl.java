package kr.co.mlec.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO login(MemberVO loginVO) {
		MemberVO member =sqlSession.selectOne("member.dao.MemberDAO.login", loginVO);
		return member;
	}

	@Override
	public MemberVO selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	

}
