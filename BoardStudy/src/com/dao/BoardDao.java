package com.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entity.Board;
import com.jdbc.JdbcContext;

public class BoardDao {
	private DataSource dataSource;
	private JdbcContext jdbcContext;

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

	private RowMapper<Board> articleMapper = (ResultSet rset, int rowNum) -> {
		Board board = new Board();
		board.setNo(rset.getInt("no"));
		board.setTitle(rset.getString("title"));
		board.setContent(rset.getString("content"));
		board.setWriteDate(rset.getDate("write_date"));
		board.setId(rset.getString("id"));
		board.setName(rset.getString("name"));
		return board;
	};

	public List<Board> getBoardList() {
		return jdbcTemplate.query("select * from board order by no desc", this.articleMapper);
	}

	public Board getArticle(Integer id) {
		return jdbcTemplate.queryForObject("select * from board where id = ?", this.articleMapper, id);
	}

	public int insertBoard(String title, String content, String id, String name) {
		return jdbcTemplate.update(
				"insert into board(no,title, content, write_date, id,name)"
						+ " values((select ifnull(max(no),0) + 1 from (select * from board) b),?,?,sysdate(),?,?)",
				title, content, id, name);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
