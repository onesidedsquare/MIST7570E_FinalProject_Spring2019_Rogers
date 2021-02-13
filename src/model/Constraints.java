package model;

/**
 * 
 * @author rogers
 * provides consistent data across the project
 *
 */
public interface Constraints {
	
	//These codes are the same codes used in the database
	public static final String GREENCODE = "GR";
	public static final String GRAPECODE = "GP";
	public static final String ORANGECODE = "OR";
	public static final String YELLOWCODE = "YE";
	
	//database connection strings
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DBNAME = "MIST7570E_FinalProject_Spring2019_Rogers";
	public static final String DBUSER = "root";
	public static final String DBPWD = "Marines!1";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//Products sessions that store their data price/inventory
	public static final String SessionGreenProduct = "SessionGreenProduct";
	public static final String SessionGrapeProduct = "SessionGrapeProduct";
	public static final String SessionYellowProduct = "SessionYellowProduct";
	public static final String SessionOrangeProdcut = "SessionOrangeProdcut";
	
	//This stores the users order data
	public static final String SessionOrder = "SessionOrder";
	
	//this is the users session
	public static final String SessionUser = "SessionUser";
	
	//if any request tables are sent to jsp
	public static final String RequestTable = "RequestTable";
}
