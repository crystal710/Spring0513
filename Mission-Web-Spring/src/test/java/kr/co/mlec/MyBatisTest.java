package kr.co.mlec;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MyBatisTest {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DataSource ds;
	
	
	@Ignore
	@Test
	public void 조회수증가테스트() throws Exception{
		int a =sqlSession.update("board.dao.BoardDAO.viewCnt",5);
		System.out.println("조회수 : " + a);
	}
	
	@Ignore
	@Test
	public void 새글등록테스트() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("집에갈뤠~~~~");
		board.setWriter("김에은");
		board.setContent("집보내줘");
		
		sqlSession.insert("board.dao.BoardDAO.insert",board);
	}
	
	@Ignore
	@Test
	public void 상세게시글조회테스트() throws Exception{
		BoardVO board = sqlSession.selectOne("board.dao.BoardDAO.selectByNo",5);
		System.out.println(board);
	}
	
	@Ignore
	@Test
	public void 전체게시글조회테스트() throws Exception{
		List<BoardVO> list = sqlSession.selectList("board.dao.BoardDAO.selectAll");
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Ignore
	@Test
	public void salSessionTemplate테스트() throws Exception{
		assertNotNull(sqlSession);
	}
	
	@Ignore
	@Test
	public void DB접속테스트() throws Exception{
		assertNotNull(ds);
	}
	
	
}
