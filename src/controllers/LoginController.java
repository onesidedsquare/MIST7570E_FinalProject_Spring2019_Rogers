package controllers;

import dbHelpers.ReadOrder;
import dbHelpers.UserHelper;

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
import utilities.PasswordService;

/**
 * Servlet implementation class LoginController
 * A controller for handling user authentication and login
 */
@WebServlet(description = "A controller for handling user logins", urlPatterns = { "/Login" })
public class LoginController extends HttpServlet implements Constraints {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3690928068945613136L;
	private HttpSession session; 
	private String url;
	private int loginAttempts;

	/**
	 * Servlet constructor
	 */
	public LoginController() {
		super();
	}

	/**
	 * Process GET requests/responses (logout)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//User has clicked the logout link
		session = request.getSession();

		//check to make sure we've clicked link
		if(request.getParameter("logout") !=null){

			//logout and redirect to frontpage
			logout();
			url="index.jsp";
		}

		//forward our request along
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * Process POST requests/responses (login)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get our current session
		session = request.getSession();

		//get the number of logins
		if(session.getAttribute("loginAttempts") == null){
			loginAttempts = 0;
		}
		
		//exceeded logins
		if(loginAttempts > 2){
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			request.setAttribute("errorMessage", errorMessage);
			url = "index.jsp";
		}else{	//proceed
			//pull the fields from the form
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//encrypt the password to check against what's stored in DB
			PasswordService pws = new PasswordService();
			String encryptedPass = pws.encrypt(password);
			
			//create a user helper class to make database calls, and call authenticate user method
			UserHelper uh = new UserHelper();
			User user = uh.authenticateUser(username, encryptedPass);

			//we've found a user that matches the credentials
			if(user != null){
				//invalidate current session, then get new session for our user (combats: session hijacking)

				session.invalidate();
				session=request.getSession(true);
				
				//recover order
				ReadOrder rc = new ReadOrder();
				rc.doRead(user);
				Order order = rc.getOrder();
				
				session.setAttribute(SessionOrder, order);
				session.setAttribute(SessionUser, user);
				url="ReadProducts";
				request.setAttribute("message", "Login Successful as " + username);
			}
			// user doesn't exist, redirect to previous page and show error
			else{
				String errorMessage = "Error: Unrecognized Username or Password<br>Login attempts remaining: "+(3-(loginAttempts));
				request.setAttribute("errorMessage", errorMessage);

				//track login attempts (combats: brute force attacks)
				session.setAttribute("loginAttempts", loginAttempts++);
				url = "login.jsp";
			}
		}
		//forward our request along
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * Logs the user out
	 */
	public void logout() {
		session.invalidate();
	}
}
