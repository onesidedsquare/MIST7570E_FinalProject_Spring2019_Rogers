package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Constraints;
import model.Order;
import model.Product;

public class PurchaseOrder implements Constraints{
	
	public Connection connection;
	
	public PurchaseOrder(){
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
	
	public void ApplyUpdate(Order order){
		
		
		try {
			ReadProducts rp = new ReadProducts();
			rp.doRead(GREENCODE);
			Product productGreen = rp.getInventory();
					
			rp.doRead(YELLOWCODE);
			Product productYellow = rp.getInventory();
			
			rp.doRead(GRAPECODE);
			Product productGrape = rp.getInventory();
			
			rp.doRead(ORANGECODE);
			Product productOrange = rp.getInventory();
			
			int green = productGreen.getInventory() - order.getGreen_quantity();
			int yellow = productYellow.getInventory() - order.getYellow_quantity();
			int grape = productGrape.getInventory() - order.getGrape_quantity();
			int orange = productOrange.getInventory() - order.getOrange_quantity();
			
			String update_query_product = "update product set inventory=? where productID = ?";
			
			PreparedStatement psp = connection.prepareStatement(update_query_product);
			
			psp.setInt(1, green);
			psp.setString(2, GREENCODE);
			psp.executeUpdate();
			
			psp.setInt(1, yellow);
			psp.setString(2, YELLOWCODE);
			psp.executeUpdate();
			
			psp.setInt(1, grape);
			psp.setString(2, GRAPECODE);
			psp.executeUpdate();
			
			psp.setInt(1, orange);
			psp.setString(2, ORANGECODE);
			psp.executeUpdate();
			
			String update_query_order = "update orders set purchased=? where userID = ? and purchased=?";
			//PreparedStatement pso = connection.prepareStatement(update_query_order);
			psp = connection.prepareStatement(update_query_order);
			psp.setBoolean(1, true);
			psp.setInt(2, order.getUserID());
			psp.setBoolean(3, false);
			psp.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
