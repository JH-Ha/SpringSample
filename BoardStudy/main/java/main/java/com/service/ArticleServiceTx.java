package com.service;

import java.sql.SQLException;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

public class ArticleServiceTx implements ArticleService {

	ArticleService articleService;
	PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public int insertArticle(String title, String content, String id, String name) throws SQLException {

		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());

		int ret = -1;
		try {
			ret = articleService.insertArticle(title, content, id, name);
			transactionManager.commit(status);

		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
		return ret;
	}

}
