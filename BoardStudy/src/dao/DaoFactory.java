package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import connection.AwsConnectionMaker;
import connection.ConnectionMaker;

@Configuration
public class DaoFactory {
	@Bean
	public ConnectionMaker connectionMaker() {
		return new AwsConnectionMaker();
	}

	@Bean
	public BoardDao boardDao() {
		BoardDao boardDao = new BoardDao();
		boardDao.setConnectionMaker(connectionMaker());
		return boardDao;
	}

	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}
}
