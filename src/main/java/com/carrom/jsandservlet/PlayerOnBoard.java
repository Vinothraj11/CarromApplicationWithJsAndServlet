package com.carrom.jsandservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerOnBoard
 */
@WebServlet("/PlayerOnBoard")
public class PlayerOnBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerOnBoard() {
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
		//doGet(request, response);
		String playerName1 = request.getParameter("playerName1");
		System.out.println("Player Name1 : " + playerName1);
		String playerName2 = request.getParameter("playerName2");
		System.out.println("Player Name2 : " + playerName2);
		
		Player player1 = new Player(playerName1);
		Player player2 = new Player(playerName2);
		
		Board board = new Board(9,9,1,1,false);
		request.getSession().setAttribute("board", board);
		request.getSession().setAttribute("player1", player1);
		request.getSession().setAttribute("player2", player2);
		
		String redirectUrl = "/CarromApplicationWithJsAndServlet/Dashboard.html";
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(redirectUrl);
	}

}
