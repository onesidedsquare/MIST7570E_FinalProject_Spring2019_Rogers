package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Constraints;
import model.Order;
import model.User;

@WebServlet(description = "A controller for handling user registreation", 
urlPatterns = { "/ViewCart" })
public class ViewCartServlet extends HttpServlet implements Constraints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6330020317230081837L;
	private String url;
	
	public ViewCartServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionUser);
		Order order = (Order) session.getAttribute(SessionOrder);
		
				
		session.setAttribute(SessionUser, user);
		session.setAttribute(SessionOrder, order);
		
		url="viewCart.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		
	}
	
}
