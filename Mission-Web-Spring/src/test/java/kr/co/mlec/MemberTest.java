package kr.co.mlec;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MemberTest {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private MemberService service;
	
	@Test
	public void service_전체회원조회() throws Exception{
		List<MemberVO> list = service.selectAllMember();
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Ignore
	@Test
	public void DAO_전체회원조회() throws Exception{
		List<MemberVO> list = dao.selectAllMember();
		
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Ignore
	@Test
	public void 회원조회테스트() throws Exception{
		List<MemberVO> list = sqlSession.selectList("member.dao.MemberDAO.selectAll");
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
	}
	
	
	@Ignore
	@Test
	public void 로그인테스트() throws Exception{
		
		MemberVO loginVO =new MemberVO();
		loginVO.setId("user");
		loginVO.setPassword("user");
		
		MemberVO member =sqlSession.selectOne("member.dao.MemberDAO.login", loginVO);
		System.out.println(member);
	}

}
