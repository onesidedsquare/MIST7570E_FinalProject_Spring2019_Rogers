package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Constraints;
import model.User;

public class AddUser implements Constraints{

		
	public Connection connection;
	public ResultSet resultSet;
	
	public AddUser(){
		String url = URL + DBNAME;
		
		try {
			Class.forName(DRIVER).newInstance();
			this.connection = DriverManager.getConnection(url, DBUSER, DBPWD); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(User user){
		String query = "insert into users (username, password) values (?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int checkUserName(String username) {
		String query = "Select * from users where username=?";

		int rowCount = 0;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);			
			ps.setString(1, username);	
			resultSet = ps.executeQuery();
			resultSet.last();
			rowCount = resultSet.getRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowCount;
	}

	}
