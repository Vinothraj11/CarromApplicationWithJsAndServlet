package com.carrom.jsandservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerInfoServlet
 */
@WebServlet("/PlayerInfoServlet")
public class PlayerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Player player1 = (Player) request.getSession().getAttribute("player1");
        Player player2 = (Player) request.getSession().getAttribute("player2");

        // Convert player objects to JSON format
        String player1Json = convertPlayerToJson(player1);
        String player2Json = convertPlayerToJson(player2);

        // Construct a JSON object with player1 and player2 information
        String jsonResponse = "{ \"player1\": " + player1Json + ", \"player2\": " + player2Json + " }";

        // Send the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
	}
	
	private String convertPlayerToJson(Player player) {
        return "{\"name\":\"" + player.getName() + "\", \"score\":" + player.getScore() + "}";
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
