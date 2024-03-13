package com.carrom.jsandservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarromBoardServlet
 */
@WebServlet("/CarromBoardServlet")
public class CarromBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarromBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		System.out.println("Checking for");
		Board board = (Board) request.getSession().getAttribute("board");
		Player player1 = (Player) request.getSession().getAttribute("player1");
		System.out.println("Player1 name : " + player1.getName());
		Player player2 = (Player) request.getSession().getAttribute("player2");
		System.out.println("Player2 name : " + player2.getName());
		System.out.println("Action " + request.getParameter("action"));
		int action = Integer.parseInt(request.getParameter("action"));
		System.out.println("Action : " + action);
		if(board.getStriker() == 1) {
			if(action == 1) {
				if(player1.getPocketedRedCoins() == 1 && board.getRedCoins() == 1 && player1.getPocketedWhiteCoins() > 0) {
					player1.setScore(player1.getScore() + 3);
					board.setRedCoins(board.getRedCoins()-1);
				}
				player1.setScore(player1.getScore() + 1);
				board.setWhiteCoins(board.getWhiteCoins()-1);
				player1.setPocketedWhiteCoins(player1.getPocketedWhiteCoins() + 1);
			} else if(action == 2) {
				player1.setScore(player1.getScore() - 1);
				board.setBlackCoins(board.getBlackCoins()-1);
				board.setStriker(2);
				player1.setPocketedBlackCoins(player1.getPocketedBlackCoins() + 1);
				if(player1.getPocketedRedCoins() == 1 && board.getRedCoins() == 1) {
					player1.setPocketedRedCoins(player1.getPocketedRedCoins() - 1);
					board.setRedCoinPocketed(false);
				}
			} else if(action == 3) {
				player1.setPocketedRedCoins(player1.getPocketedRedCoins() + 1);
				board.setRedCoinPocketed(true);
			} else if(action == 4) {
				board.setStriker(2);
				if(player1.getPocketedRedCoins() == 1 && board.getRedCoins() == 1) {
					player1.setPocketedRedCoins(player1.getPocketedRedCoins() - 1);
					board.setRedCoinPocketed(false);
				}
			} else if(action == 5) {
				player1.setScore(player1.getScore() - 1);
				board.setStriker(2);
				if(player1.getPocketedRedCoins() == 1 && board.getRedCoins() == 1) {
					player1.setPocketedRedCoins(player1.getPocketedRedCoins() - 1);
					board.setRedCoinPocketed(false);
				}
			}
		} else {
			if(action == 1) {
				player2.setScore(player2.getScore() - 1);
				board.setWhiteCoins(board.getWhiteCoins()-1);
				board.setStriker(1);
				player2.setPocketedWhiteCoins(player2.getPocketedWhiteCoins() + 1);
				if(player2.getPocketedRedCoins() == 1 && board.getRedCoins() == 1) {
					player2.setPocketedRedCoins(player2.getPocketedRedCoins() - 1);
					board.setRedCoinPocketed(false);
				}
			} else if(action == 2) {
				if(player2.getPocketedRedCoins() == 1 && board.getRedCoins() == 1 && player2.getPocketedBlackCoins() > 0) {
					player2.setScore(player2.getScore() + 3);
					board.setRedCoins(board.getRedCoins() - 1);
				}
				player2.setScore(player2.getScore() + 1);
				board.setBlackCoins(board.getBlackCoins()-1);
				player2.setPocketedBlackCoins(player2.getPocketedBlackCoins() + 1);
			} else if(action == 3) {
				player2.setPocketedRedCoins(player2.getPocketedRedCoins() + 1);
				board.setRedCoinPocketed(true);
			} else if(action == 4) {
				board.setStriker(1);
				if(player2.getPocketedRedCoins() == 1 && board.getRedCoins() == 1) {
					player2.setPocketedRedCoins(player2.getPocketedRedCoins() - 1);
					board.setRedCoinPocketed(false);
				}
			} else if(action == 5) {
				player2.setScore(player2.getScore() - 1);
				board.setStriker(1);
				if(player2.getPocketedRedCoins() == 1 && board.getRedCoins() == 1) {
					player2.setPocketedRedCoins(player2.getPocketedRedCoins() - 1);
					board.setRedCoinPocketed(false);
				}
			}
		}
		System.out.println("Player1 : " + player1.getScore());
		String redirectUrl = "/CarromApplicationWithJsAndServlet/PlayGame.html";
		if(board.getWhiteCoins() == 0 || board.getBlackCoins() == 0) {
			redirectUrl = "/CarromApplicationWithJsAndServlet/EndGame.html";
		} else {
			redirectUrl = "/CarromApplicationWithJsAndServlet/PlayGame.html";
		}
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(redirectUrl);
	}

}
