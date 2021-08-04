package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.BoardDao;
import com.dao.DaoFactory;
import com.entity.Board;

@Controller
public class BoardController {

	@RequestMapping("board")
	public String getArticles(Model model) {
		BoardDao boardDao = new DaoFactory().boardDao();

		List<Board> boardList = boardDao.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board";
		// RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		// rd.forward(request, response);
	}
}
