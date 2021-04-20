package me.jose;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String firstName = request.getParameter("firstName") == null ? "Unknown" : request.getParameter("firstName");
		String lastName = request.getParameter("lastName") == null ? "Unknown" : request.getParameter("lastName");
		String favoriteLanguage = request.getParameter("favoriteLanguage") == null ? "Unknown" : request.getParameter("favoriteLanguage");
		String hometown = request.getParameter("hometown") == null ? "Unknown" : request.getParameter("hometown") ;
		
		response.setContentType("text/html");
		response.getWriter().write("<h1> Welcome, "+ firstName + " " + lastName + "</h1>");
		response.getWriter().write("<h4> Your favourite language is: "+ favoriteLanguage +"</h4>");
		response.getWriter().write("<h4> Your hometown is: "+ hometown +"</h4>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
