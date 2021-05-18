package kr.co.mlec;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MemberTest {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void DAO_로그인테스트() throws Exception{
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
