package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Constraints;
import model.Order;
import model.User;

public class ReadOrder implements Constraints{

	private Connection connection;
	private ResultSet results;
	
	public ReadOrder(){
		String url = URL + DBNAME;
	
		try {
			Class.forName(DRIVER).newInstance();
			this.connection = DriverManager.getConnection(url, DBUSER, DBPWD);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e  ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void doRead(User user){
		String query = "select * from orders where userID=? and purchased=?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.setBoolean(2, false);

			this.results= ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Order getOrder() {
		Order order = new Order();
		try {
			while(this.results.next()){
				
				order.setGreen_quantity(this.results.getInt("green_amount"));
				order.setGrape_quantity(this.results.getInt("grape_amount"));
				order.setOrange_quantity(this.results.getInt("orange_amount"));
				order.setYellow_quantity(this.results.getInt("yellow_amount"));
				order.setUserID(this.results.getInt("userID"));
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return order;
	}
	
}
