package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.BoardDao;
import com.dao.DaoFactory;
import com.entity.Board;

@Controller
public class BoardController {

	@Autowired
	BoardDao boardDao;

	@RequestMapping("board")
	public String getArticles(Model model) {
		BoardDao boardDao = new DaoFactory().boardDao();

		List<Board> boardList = boardDao.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board";
		// RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		// rd.forward(request, response);
	}

	@RequestMapping("write")
	public String writeArticle() {
		return "write";
	}

	@PostMapping("write")
	public void postArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// BoardDao boardDao = new DaoFactory().boardDao();
		// boardDao.insertBoard(title, content, user.getId(), user.getName());
		boardDao.insertBoard(title, content, "testId", "testName");
		response.sendRedirect(request.getContextPath() + "/board");
	}
}
