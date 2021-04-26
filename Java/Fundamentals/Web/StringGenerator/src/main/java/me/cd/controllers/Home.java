package me.cd.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.Date;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/StringGenerator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random r = new Random();
		String randomString = "";
		for (int i = 0; i < 10; i++) {
			if (r.nextBoolean()) {
				randomString += (char) (r.nextInt(122 - 97) + 97);
			} else {
				randomString += r.nextInt(122 - 97) + 97;
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("randomString", randomString);
		if (session.getAttribute("stringsGenerated") == null) {
			session.setAttribute("stringsGenerated", 1);
		} else {
			int stringsGenerated = (int) session.getAttribute("stringsGenerated");
			session.setAttribute("stringsGenerated", stringsGenerated + 1);
		}
		Date date = new Date();
		session.setAttribute("lastGeneratedAt", date);
		doGet(request, response);
	}

}
