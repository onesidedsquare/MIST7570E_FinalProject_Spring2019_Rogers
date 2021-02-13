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
urlPatterns = { "/RemoveFromCart"})
public class RemoveFromCartServlet extends HttpServlet implements Constraints {

		private static final long serialVersionUID = 6330020317230081837L;
		private String url;
		
		public RemoveFromCartServlet() {
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
			
			String remove = request.getParameter("remove").trim() != "" ? request.getParameter("remove") : "";
			
			UpdateOrder updateOrder = new UpdateOrder();
			
			if(remove.equals(GREENCODE)) {
				order.setGreen_quantity(0);
			}
			
			if(remove.equals(ORANGECODE)) {
				order.setOrange_quantity(0);
			}
			
			if(remove.equals(GRAPECODE)) {
				order.setGrape_quantity(0);
			}
			
			if(remove.equals(YELLOWCODE)) {
				order.setYellow_quantity(0);
			}
			
			if(remove.trim() != "") {
				order.setUserID(user.getId());
				updateOrder.doUpdate(order);
			}
			
			session.setAttribute(SessionUser, user);
			session.setAttribute(SessionOrder, order);
			
			url="viewCart.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			    dispatcher.forward(request, response);
			
		}
		
	}