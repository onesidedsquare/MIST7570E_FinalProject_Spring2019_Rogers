package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.OrderHistory;
import model.Constraints;
import model.User;

@WebServlet(
		description = "Controller for reading the products table", 
		urlPatterns = {"/ViewPurchases"} )
public class ViewOrderHistoryServlet extends HttpServlet implements Constraints {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2015927714998780121L;

	public ViewOrderHistoryServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = new User(); 
		user =	(User) session.getAttribute(SessionUser);
		String table = "";
		
		if(user != null) {
			OrderHistory goh = new OrderHistory();
			goh.getHistory(user);
			table = goh.getHTMLTable();
		} else {
			session.setAttribute("errorMessage", "Login to see history");
		}

		request.setAttribute("table", table);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("orderHistory.jsp");
		dispatcher.forward(request, response);
		
	}
}