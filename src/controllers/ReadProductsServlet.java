package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.ReadProducts;
import model.Constraints;
import model.Product;
/**
 * 
 *  @author rogers
 *  Reads products from the database and puts them on the session
 *
 */
@WebServlet(
		description = "Controller for reading the products table", 
		urlPatterns = {"/ReadProducts"} )
public class ReadProductsServlet extends HttpServlet implements Constraints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996168767288293271L;

	public ReadProductsServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a ReadQuery helper object
		ReadProducts rp = new ReadProducts();
		
		rp.doRead(GREENCODE);
		Product productGreen = rp.getInventory();
		
		rp.doRead(YELLOWCODE);
		Product productYellow = rp.getInventory();
		
		rp.doRead(GRAPECODE);
		Product productGrape = rp.getInventory();
		
		rp.doRead(ORANGECODE);
		Product productOrange = rp.getInventory();
				
		HttpSession session = request.getSession();
		session.setAttribute(SessionGreenProduct, productGreen);
		session.setAttribute(SessionYellowProduct, productYellow);
		session.setAttribute(SessionGrapeProduct, productGrape);
		session.setAttribute(SessionOrangeProdcut, productOrange);
		String url = "/shop.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
