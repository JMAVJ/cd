package me.cd.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.cd.models.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.List;

/**
 * Servlet implementation class Timer
 */
@WebServlet("/Timer")
public class Timer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action.equals("start")) {
			session.setAttribute("running", new Time());
		} else if (action.equals("stop")) {
			Time currentTime = (Time) session.getAttribute("running");
			currentTime.stop();
			List<Time> times;
			if (session.getAttribute("times") == null) {
				times = new ArrayList<Time>();
			} else {
				times = (List<Time>) session.getAttribute("times");				
			}
			times.add(currentTime);
			session.setAttribute("times", times);
			session.setAttribute("running", null);
		} else if (action.equals("reset")) {
			session.invalidate();
		}
		response.sendRedirect("/Timer/Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
