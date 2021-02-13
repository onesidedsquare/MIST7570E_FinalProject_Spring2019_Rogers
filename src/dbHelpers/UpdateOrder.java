package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Constraints;
import model.Order;

public class UpdateOrder implements Constraints{

private Connection connection;
	
	public UpdateOrder(){
		
		String url = URL + DBNAME;
		//com.mysql.jdbc.Driver
		try {
			Class.forName(DRIVER).newInstance();
			this.connection = DriverManager.getConnection(url,  DBUSER, DBPWD);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdate(Order o){
		String update_query = "update orders set green_amount=?, yellow_amount=?, grape_amount=?, orange_amount=? where userID=? and purchased=?";
		String new_query = "insert into orders (green_amount, yellow_amount, grape_amount, orange_amount, userID, purchased) values (?,?,?,?,?,?)";
		
		try {

			PreparedStatement ps = connection.prepareStatement(update_query);
						
			int green = o.getGreen_quantity();
			int yellow = o.getYellow_quantity();
			int grape = o.getGrape_quantity();
			int orange = o.getOrange_quantity();
			
		    ps = connection.prepareStatement(update_query);
			ps.setInt(1, green);
			ps.setInt(2, yellow);
			ps.setInt(3, grape);
			ps.setInt(4, orange);
						
			ps.setInt(5, o.getUserID());
			ps.setBoolean(6, false);
		
			int count = ps.executeUpdate();
			if (count == 0) {
				ps = connection.prepareStatement(new_query);
				ps.setInt(1, green);
				ps.setInt(2, yellow);
				ps.setInt(3, grape);
				ps.setInt(4, orange);
							
				ps.setInt(5, o.getUserID());
				ps.setBoolean(6, false);
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setPurhased(Order o) {
	
		String update_query = "update orders set purchased=? where userID=? and purchased=?";
		
		try {

			PreparedStatement ps = connection.prepareStatement(update_query);
		    ps = connection.prepareStatement(update_query);
			
		    ps.setBoolean(1, true);			
			ps.setInt(2, o.getUserID());
			ps.setBoolean(3, false);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
