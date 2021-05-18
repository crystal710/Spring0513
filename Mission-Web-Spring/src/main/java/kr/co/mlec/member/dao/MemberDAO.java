package kr.co.mlec.member.dao;

import java.util.List;

import kr.co.mlec.member.vo.MemberVO;

public interface MemberDAO {
	
	/**
	 * login
	 */
	public MemberVO login(MemberVO loginVO);

	/**
	 * 회원 id에 해당 회원 조회 서비스
	 * @param no 조회할 번호
	 */
	public MemberVO selectById(String id);
	
	/**
	 * 전체 회원 조회
	 */
	public List<MemberVO> selectAllMember();
	
	/**
	 * 새로운 회원 등록서비스
	 */
	public void insert(MemberVO member);
	
	/**
	 * 회원정보 수정 서비스
	 */
	public void update(MemberVO member);
	
	/**
	 * 회원 삭제 서비스
	 */
	public void delete(String id);
}
