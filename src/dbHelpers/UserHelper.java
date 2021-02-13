package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Constraints;
import model.User;

/**
 * This class is used to insert, retrieve, and update users in the user table.
 */
public class UserHelper implements Constraints{
	
	/**
	 * Prepared SQL statement (combats: SQL Injections)
	 */
	
	public Connection connection;
	
	/**
	 * Constructor which makes a connection
	 */
	public UserHelper() {
		try {
			//Set up connection		
			String url = URL + DBNAME;
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,  DBUSER, DBPWD); 
			
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Authenticates a user in the database.
	 * @param username  The username for the user.
	 * @param password  The password for the user.
	 * @return A user object if successful, null if unsuccessful.
	 */
	public User authenticateUser(String username, String password) {
		User user = null;
		String query = "select * from users where username=? and password=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			//if we've returned a row, turn that row into a new user object
			if (rs.next()) {
				user = new User(rs.getInt("userID"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}


}
