package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.PurchaseOrder;
import dbHelpers.UpdateOrder;
import model.Constraints;
import model.Order;
import model.User;
/**
 * 
 * @author rogers
 * Handles Cart purchases, deletes inventory from database and updates the order
 */
@WebServlet(description = "A controller for handling user registreation", 
urlPatterns = { "/Purchase" })
public class PurchaseCartServlet extends HttpServlet implements Constraints {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4736494651190168697L;
	public PurchaseCartServlet() {
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
		User user = (User) session.getAttribute(SessionUser);
		
		if(user != null) {
			order.setUsername(user.getUsername());
			order.setUserID(user.getId());
		} 
		
		updateOrder.doUpdate(order);
		
		PurchaseOrder pc = new PurchaseOrder();
		pc.ApplyUpdate(order);
		
		order = new Order();
		session.setAttribute(SessionOrder, order);
		request.setAttribute("messageOrder", "Thank you for your Order!");
					
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}

}
