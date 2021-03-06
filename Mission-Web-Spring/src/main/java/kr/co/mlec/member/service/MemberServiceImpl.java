package kr.co.mlec.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO login(MemberVO loginVO) {
		MemberVO member = memberDAO.login(loginVO);
		return member;
	}
	
	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> memberList = memberDAO.selectAllMember();
		return memberList;
	}

	@Override
	public MemberVO detailMember(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMember(MemberVO member) {
		memberDAO.insert(member);
		
	}

	@Override
	public int idChk(MemberVO member) {
		int result = memberDAO.idChk(member);
		return result;
	}

	
}
