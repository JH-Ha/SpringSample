package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Board;

public class BoardDao {
	private DataSource dataSource;

	public BoardDao() {

	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public BoardDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Board> getBoardList() {
		List<Board> boardList = new ArrayList<Board>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {

			conn = this.dataSource.getConnection();

			String sql = "select * from board order by no desc";
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Board board = new Board();
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setWriteDate(rset.getDate("write_date"));
				board.setId(rset.getString("id"));
				board.setName(rset.getString("name"));
				boardList.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boardList;
	}

	public int jdbcContextWithStatementStrategy(StatementStrategy stmt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = -1;
		try {

			conn = this.dataSource.getConnection();
			pstmt = stmt.makePreparedStatement(conn);
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public int insertBoard(String title, String content, String id, String name) {
		return jdbcContextWithStatementStrategy((Connection conn) -> {
			PreparedStatement pstmt;
			String sql = "insert into board(no,title, content, write_date, id,name)"
					+ " values((select ifnull(max(no),0) + 1 from (select * from board) b),?,?,sysdate(),?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			pstmt.setString(4, name);
			return pstmt;
		});
	}
}
