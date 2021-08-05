package com.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entity.Article;
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

	private RowMapper<Article> articleMapper = (ResultSet rset, int rowNum) -> {
		Article board = new Article();
		board.setNo(rset.getInt("no"));
		board.setTitle(rset.getString("title"));
		board.setContent(rset.getString("content"));
		board.setWriteDate(rset.getDate("write_date"));
		board.setId(rset.getString("id"));
		board.setName(rset.getString("name"));
		return board;
	};

	public List<Article> getBoardList() {
		return jdbcTemplate.query("select * from article order by no desc", this.articleMapper);
	}

	public Article getArticle(Integer id) {
		return jdbcTemplate.queryForObject("select * from article where id = ?", this.articleMapper, id);
	}

	public int insertBoard(String title, String content, String id, String name) {
		return jdbcTemplate.update(
				"insert into article(no,title, content, write_date, id,name)"
						+ " values((select ifnull(max(no),0) + 1 from (select no from article) b),?,?,sysdate(),?,?)",
				title, content, id, name);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
