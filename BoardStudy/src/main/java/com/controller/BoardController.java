package com.controller;

import com.dao.BoardDao;
import com.dao.DaoFactory;
import com.entity.Article;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

  @Autowired
  BoardDao boardDao;

  @RequestMapping("/")
  public String helloSpringStudy() {
    return "hello";
  }

  @Autowired
  DaoFactory daoFactory;

  @RequestMapping("articles")
  public String getArticles(Model model) {
    BoardDao boardDao = daoFactory.boardDao();

    List<Article> boardList = boardDao.getBoardList();
    model.addAttribute("boardList", boardList);
    return "board";
    // RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
    // rd.forward(request, response);
  }

  @GetMapping("article/{id}")
  public String getArticle(Model model, @PathVariable(name = "id") Integer id) {
    Article board = boardDao.getArticle(id);
    model.addAttribute("article", board);
    return "article";
  }

  @RequestMapping("write")
  public String writeArticle() {
    return "write";
  }

  @PostMapping("write")
  public void postArticle(HttpServletRequest request, HttpServletResponse response)
      throws IOException, SQLException {
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    // BoardDao boardDao = new DaoFactory().boardDao();
    // boardDao.insertBoard(title, content, user.getId(), user.getName());
    boardDao.insertBoard(title, content, "testId", "testName");
    response.sendRedirect(request.getContextPath() + "/articles");
  }
}
