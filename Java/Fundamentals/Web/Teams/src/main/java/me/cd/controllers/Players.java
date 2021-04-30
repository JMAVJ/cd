package me.cd.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import me.cd.models.Player;
import me.cd.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("action") != null) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
			for (Team team : teams) {
				if (team.getId() == Integer.parseInt(request.getParameter("teamId"))) {
					List<Player> players = team.getPlayers();
					players.removeIf(p -> (p.getId() == Integer.parseInt(request.getParameter("playerId"))));
					team.setPlayers(players);
					break;
				}
			}
			response.sendRedirect("/Teams/Teams?id=" + request.getParameter("teamId"));
			return;
		}
		request.setAttribute("teamId", request.getParameter("teamId"));
		request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		for (Team team : teams) {
			if (team.getId() == teamId) {
				team.addPlayer(request.getParameter("firstName"), request.getParameter("lastName"), Integer.parseInt(request.getParameter("age")));
				break;
			}
		}
		response.sendRedirect("/Teams/Teams?id=" + String.valueOf(teamId));
	}

}
