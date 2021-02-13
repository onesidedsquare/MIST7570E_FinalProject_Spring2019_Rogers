package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UpdateOrder;
import model.Constraints;
import model.Order;
import model.User;

@WebServlet(description = "A controller for handling user registreation", 
urlPatterns = { "/SaveForLater" })
public class SaveCartServlet extends HttpServlet implements Constraints{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1275996808548549411L;

	public SaveCartServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UpdateOrder updateOrder = new UpdateOrder();
		HttpSession session = request.getSession();
		
		Order order = new Order();
		order = (Order) session.getAttribute(SessionOrder);
		
		User user = new User(); 
		user =	(User) session.getAttribute(SessionUser);
		
		if(user != null) {
		
			order.setUserID(user.getId());
			updateOrder.doUpdate(order);
			
		} else {
			session.setAttribute("errorMessage", "Login to save cart for later");
		}
		
		String pathTrace = (String) request.getParameter("page");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pathTrace);
		dispatcher.forward(request, response);
		
	}

}
