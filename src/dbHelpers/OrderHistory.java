package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Constraints;
import model.Order;
import model.User;

public class OrderHistory implements Constraints{

private Connection connection;
private ResultSet results;
	
	public OrderHistory(){
		
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
	
	public void getHistory(User user) {
		String update_query = "select * from orders where userID=? and purchased=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(update_query);
			ps.setInt(1, user.getId());
			ps.setBoolean(2, true);	
			results = ps.executeQuery();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table ="";
		table += "<table border=1>";
		table +="<tr>";
		table +="<td>Order ID</td>";
		table +="<td>Green Limes</td>";
		table +="<td>Yellow Limes</td>";
		table +="<td>Grape Limes</td>";
		table +="<td>Orange Limes</td>";
		table +="</tr>\n";
		
		try {
			while(this.results.next()){
				Order order = new Order();
				order.setOrderID(this.results.getInt("orderID"));
				order.setGreen_quantity(this.results.getInt("green_amount"));
				order.setYellow_quantity(this.results.getInt("yellow_amount"));
				order.setGrape_quantity(this.results.getInt("grape_amount"));
				order.setOrange_quantity(this.results.getInt("orange_amount"));

				table +="<tr>";
				table +="<td>";
				table += order.getOrderID();
				table +="</td>";
				table +="<td>";
				table += order.getGreen_quantity();
				table +="</td>";
				table +="<td>";
				table += order.getYellow_quantity();
				table +="</td>";
				table +="<td>";
				table += order.getGrape_quantity();
				table +="</td>";
				table +="<td>";
				table += order.getOrange_quantity();
				table +="</td>";
				table +="</tr>\n";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
	
}
