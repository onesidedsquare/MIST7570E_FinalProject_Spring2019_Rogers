package model;

public class Order {
	private String username;
	private int userID;

	private int orderID;

	private int green_quantity;
	private int yellow_quantity;
	private int grape_quantity;
	private int orange_quantity;
	
	private boolean purchased;
	
	/**
	 * Guest data is for users that want to purchase with having to login
	 */
	public Order() {
		this.username = "guest";
		this.userID = 3;
		
		this.green_quantity = 0;
		this.yellow_quantity = 0;
		this.grape_quantity = 0;
		this.orange_quantity = 0;
		
		this.purchased = false;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public int getGreen_quantity() {
		return green_quantity;
	}
	public void setGreen_quantity(int green_quantity) {
		this.green_quantity = green_quantity;
	}
	public int getYellow_quantity() {
		return yellow_quantity;
	}
	public void setYellow_quantity(int yellow_quantity) {
		this.yellow_quantity = yellow_quantity;
	}
	public int getGrape_quantity() {
		return grape_quantity;
	}
	public void setGrape_quantity(int grape_quantity) {
		this.grape_quantity = grape_quantity;
	}
	public boolean isPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	public int getOrange_quantity() {
		return orange_quantity;
	}
	public void setOrange_quantity(int orange_quantity) {
		this.orange_quantity = orange_quantity;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
}
