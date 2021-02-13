package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddUser;
import model.User;
import utilities.PasswordService;

/**
 * 
 * @author rogers
 * Handles new user registration
 */
@WebServlet(description = "A controller for handling user registreation", 
	urlPatterns = { "/Registration" })
public class RegistrationServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5175564636283385778L;
	private String url;

	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password_1 = request.getParameter("password_1");
		String password_2 = request.getParameter("password_2");
		
		PasswordService pws = new PasswordService();
		
		if(username == null) {
			String errorMessage = "Error: No Username" ;
			request.setAttribute("errorMessage", errorMessage);

			url = "register.jsp";
		} else if (!password_1.equals(password_2)) {
			String errorMessage = "Error: Passwords Do Not Match" ;
			request.setAttribute("errorMessage", errorMessage);

			url = "register.jsp";
		} else if (!pws.isGood(password_1)) {
			String errorMessage = "Error: Passwords are not complex(Letters and Numbers or long enough(8+)" ;
			request.setAttribute("errorMessage", errorMessage);

			url = "register.jsp";
		} else {
			String encryptedPw = pws.encrypt(password_1);
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(encryptedPw);
			
			// set up an addQuery object
		    AddUser au = new AddUser();
		    
		    int checkUserAvailablity =  au.checkUserName(username);
		    
		    if(checkUserAvailablity == 0) {
				// pass the food to addQuery to add to the database
			    au.doAdd(user);
			    
			    request.setAttribute("message", "Registration of <b>" + username + "</b> successful");
				// pass execution control to the ReadServlet
			    url = "login.jsp";
		    } else {
		    	String errorMessage = "Error: Username <b>" + username + "</b> Exists" ;
				request.setAttribute("errorMessage", errorMessage);

				url = "register.jsp";
		    }
		}
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}
