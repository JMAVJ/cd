package me.cd.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.cd.models.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	if (request.getParameter("id") == null) {
    		request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp").forward(request, response);
    		return;
    	}

    	HttpSession session = request.getSession();
    	List<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
    	int teamId = Integer.parseInt(request.getParameter("id"));

    	if(request.getParameter("action") != null) {
    		if (request.getParameter("action").equals("delete")) {
    			teams.removeIf(t -> t.getId() == teamId);
    			session.setAttribute("teams", teams);
    		}
    		response.sendRedirect("/Teams/Home");
    		return;
		}
		
		for (Team team : teams) {
			if (team.getId() == teamId) {
				request.setAttribute("team", team);
				break;
			}
		}
		request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Route to add a team
		HttpSession session = request.getSession();
		if(session.getAttribute("teams") == null) {
			List<Team> teams = new ArrayList<Team>();
			session.setAttribute("teams", teams);
		}
		@SuppressWarnings("unchecked")
		List<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
		Team newTeam = new Team(request.getParameter("teamName"));
		teams.add(newTeam);
		request.setAttribute("teams", teams);
		response.sendRedirect("/Teams/Home");
	}
}
