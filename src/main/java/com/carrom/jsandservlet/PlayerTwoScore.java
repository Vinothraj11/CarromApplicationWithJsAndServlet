package com.carrom.jsandservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Player2Score
 */
@WebServlet("/PlayerTwoScore")
public class PlayerTwoScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerTwoScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Debug player2Score");
		Player player = (Player) request.getSession().getAttribute("player2");
		
		System.out.println("Player1 name " + player.getName());
		
		String playerJson = convertPlayerToJson(player);

        response.setContentType("application/json");
        response.getWriter().write(playerJson);
	}
	
	private String convertPlayerToJson(Player player) {
        return String.format("{\"name\":\"%s\", \"score\":" + player.getScore() + 
        		",\"pocketedWhiteCoins\":" + player.getPocketedWhiteCoins() + ",\"pocketedBlackCoins\":" + player.getPocketedBlackCoins() + 
        		",\"pocketedRedCoins\":" + player.getPocketedRedCoins() + "}", player.getName());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
