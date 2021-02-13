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
import model.Product;
import model.User;
/**
 * 
 * @author rogers
 *Servelts impl for users updated cart information to the order
 *
 */
@WebServlet(
		description = "Controller for reading the products table", 
		urlPatterns = {"/addToCart"} )
public class AddToCartServlet extends HttpServlet implements Constraints {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5823821996321617740L;
	
	public AddToCartServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user entry data
		int green_amount = request.getParameter("gr_amount").trim() != "" ? Integer.parseInt(request.getParameter("gr_amount").trim()) : 0;
		int grape_amount = request.getParameter("gp_amount").trim() != "" ? Integer.parseInt(request.getParameter("gp_amount").trim()) : 0;
		int yellow_amount = request.getParameter("ye_amount").trim() != "" ? Integer.parseInt(request.getParameter("ye_amount").trim()) : 0;
		int orange_amount = request.getParameter("or_amount").trim() != "" ? Integer.parseInt(request.getParameter("or_amount").trim()) : 0;
		
		//get the sessions
		HttpSession session = request.getSession();
		Product gn = (Product) session.getAttribute(SessionGreenProduct);
		Product rp = (Product) session.getAttribute(SessionGrapeProduct);
		Product ye = (Product) session.getAttribute(SessionYellowProduct);
		Product or = (Product) session.getAttribute(SessionOrangeProdcut);
		
		Order order = new Order();
		int chk = 0;
		
		//check green amounts & add to order
		if(green_amount < gn.getInventory()) {
			order.setGreen_quantity(green_amount);
		} else {
			chk++;
			order.setGreen_quantity(0);
			request.setAttribute("green_error", "We do not have " + green_amount + " in stock, please select fewer");
		}
		
		//check green amounts & add to order
		if(grape_amount < rp.getInventory()) {
			order.setGrape_quantity(grape_amount);
		} else {
			chk++;
			order.setGrape_quantity(0);
			request.setAttribute("grape_error", "We do not have " + grape_amount + " in stock, please select fewer");
		}
		
		//check green amounts & add to order
		if(yellow_amount < ye.getInventory()) {
			order.setYellow_quantity(yellow_amount);
		} else {
			chk++;
			order.setGreen_quantity(0);
			request.setAttribute("yellow_error", "We do not have " + yellow_amount + " in stock, please select fewer");
		}
		
		//check green amounts & add to order
		if(orange_amount < or.getInventory()) {
			order.setOrange_quantity(orange_amount);
		} else {
			chk++;
			order.setOrange_quantity(0);
			request.setAttribute("orange_error", "We do not have " + orange_amount + " in stock, please select fewer");
		}
		
		//if user is logged in, order is updated in database
		User user = new User(); 
		user =	(User) session.getAttribute(SessionUser);
		if(user != null && chk == 0) {
			
			UpdateOrder updateOrder = new UpdateOrder();
			order.setUserID(user.getId());
			updateOrder.doUpdate(order);
			
		} else {
			session.setAttribute("errorMessage", "Login to save cart for later");
		}
		
		String var = "<input=\"text\" />"; 
		
		session.setAttribute(SessionOrder, order);
		session.setAttribute("message", "Cart Updated");

		String url = "ReadProducts";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
