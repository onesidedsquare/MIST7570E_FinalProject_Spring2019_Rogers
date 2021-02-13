package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Constraints;
import model.Product;

public class ReadProducts implements Constraints{

	private Connection connection;
	private ResultSet results;
	
	public ReadProducts(){
		String url = URL + DBNAME;
	
		try {
			Class.forName(DRIVER).newInstance();
			this.connection = DriverManager.getConnection(url, DBUSER, DBPWD);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e  ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void doRead(String productID){
		String query = "select * from product where productID = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setString(1, productID);
			this.results= ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Product getInventory() {
		Product product = new Product();
		try {
			while(this.results.next()){
				
				product.setProductID(this.results.getString("productID"));
				product.setProductName(this.results.getString("productName"));
				product.setPrice(this.results.getDouble(3));
				product.setQuantity(this.results.getInt(4));
				product.setInventory(this.results.getInt(5));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return product;
	}
	
	public Product getInventory(String productID) {
		Product product = new Product();
		try {
			while(this.results.next()){
				if(this.results.getString("productID").equals(productID)) {
					product.setProductID(this.results.getString("productID"));
					product.setProductName(this.results.getString("productName"));
					product.setPrice(this.results.getDouble(3));
					product.setQuantity(this.results.getInt(4));
					product.setInventory(this.results.getInt(5));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return product;
	}
	
}
