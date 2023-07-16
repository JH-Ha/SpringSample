package com.service;

import java.sql.SQLException;

public interface ArticleService {
	public int insertArticle(String title, String content, String id, String name) throws SQLException;
}
