package kr.co.mlec;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MyProjectTest {

	@Autowired
	private BoardService service;
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void SERVICE_상세페이지조회() throws Exception{
		BoardVO board = service.detailBoard(3);
		System.out.println(board);
	}
	
	@Ignore
	@Test
	public void DAO_상세페이지조회() throws Exception{
		BoardVO board = dao.selectByNo(3);
		System.out.println(board);
	}
	
	@Ignore
	@Test
	public void SERVICE_전체게시글조회() throws Exception{
		List<BoardVO> list = service.selectAllBoard();
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	@Ignore //junit test실행시 무시
	@Test
	public void DAO_전체게시글조회() throws Exception{
		List<BoardVO> list = dao.selectAll();
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
}
