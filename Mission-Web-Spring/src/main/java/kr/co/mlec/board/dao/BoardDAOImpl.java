package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.mlec.board.util.ConnectionFactory;
import kr.co.mlec.board.util.JDBCClose;
import kr.co.mlec.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<BoardVO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("  from t_board ");
			sql.append(" order by no ");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");

				BoardVO board = new BoardVO(no, title, writer, regDate);
				list.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}

	@Override
	public BoardVO selectByNo(int no) {
		Connection 			conn = null;
		PreparedStatement 	pstmt = null;
		BoardVO 			board = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, content, view_cnt ");
			sql.append("       , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("  from t_board ");
			sql.append(" where no = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int boardNo = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				board = new BoardVO(boardNo, title, writer, content, viewCnt, regDate);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return board;
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("delete t_board ");
			sql.append(" where no = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

}
