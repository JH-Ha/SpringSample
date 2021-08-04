package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entity.Board;
import com.jdbc.JdbcContext;

public class BoardDao {
	private DataSource dataSource;
	private JdbcContext jdbcContext;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BoardDao() {

	}

	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
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

	public int insertBoard(String title, String content, String id, String name) {
		return jdbcTemplate.update(
				"insert into board(no,title, content, write_date, id,name)"
						+ " values((select ifnull(max(no),0) + 1 from (select * from board) b),?,?,sysdate(),?,?)",
				title, content, id, name);
	}
}
