package com.service;

import java.sql.SQLException;

public interface ArticleService {
	int insertArticle(String title, String content, String id, String name) throws SQLException;
}
