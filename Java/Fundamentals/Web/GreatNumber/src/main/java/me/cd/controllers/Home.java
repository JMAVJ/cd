package me.cd.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Random;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random r = new Random();
		HttpSession session = request.getSession();
		if (session.getAttribute("randomNumber") == null) {
			int randomNumber = r.nextInt(100);
			session.setAttribute("randomNumber", randomNumber);
		}
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (Integer.parseInt(request.getParameter("number")) == (int) session.getAttribute("randomNumber")) {
			request.setAttribute("won", true);
			doGet(request, response);
			return;
		}
		if (Integer.parseInt(request.getParameter("number")) > (int) session.getAttribute("randomNumber")) {
			request.setAttribute("result", "Too high");
		} else if (Integer.parseInt(request.getParameter("number")) < (int) session.getAttribute("randomNumber")) {
			request.setAttribute("result", "Too low");
		}
		doGet(request, response);
	}

}
