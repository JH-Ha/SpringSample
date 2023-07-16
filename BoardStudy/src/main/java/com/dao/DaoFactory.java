package com.dao;

import com.connection.AwsConnectionMaker;
import com.connection.ConnectionMaker;
import com.jdbc.JdbcContext;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DaoFactory {

  @Bean
  public ConnectionMaker connectionMaker() {
    return new AwsConnectionMaker();
  }

  @Bean
  public DataSource dataSource() {

    String url = "jdbc:h2:mem:testdb";
    String username = "sa";
    DataSourceBuilder builder = DataSourceBuilder.create()
        .url(url)
        .username(username)
        .driverClassName(org.h2.Driver.class.getName());
    return builder.build();
  }

  @Bean
  public BoardDao boardDao() {
    BoardDao boardDao = new BoardDao();
    boardDao.setDataSource(dataSource());
    boardDao.setJdbcContext(jdbcContext());
    boardDao.setJdbcTemplate(jdbcTemplate());
    // boardDao.setConnectionMaker(connectionMaker());
    return boardDao;
  }

  @Bean
  public UserDao userDao() {
    UserDao userDao = new UserDao(connectionMaker());
    return userDao;
  }

  @Bean
  public JdbcContext jdbcContext() {
    JdbcContext jdbcContext = new JdbcContext();
    jdbcContext.setDataSource(dataSource());
    return jdbcContext;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }
}
