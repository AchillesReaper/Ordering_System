package orderingSystem;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql_1Control {
	public static final String URL = "jdbc:mysql://localhost:3306/orderingsystem";
    public static final String USER = "root";
    public static final String PASSWORD = "!Q@W3e4r";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	
//  CRUD: Create
	public static void newTransaction(CustomerOrder newTransc) {
//		String tno = "abc";
		String tno = newTransc.getTransactionNumber();
		String oType = newTransc.getOrderType();
		String ono = newTransc.getOrderNumber();
		String fType = newTransc.getFoodType();
		String fContent = newTransc.getContent();
		String pzsize = newTransc.getSize();
		int fAmount = newTransc.getAmount();
		Double fPrice = newTransc.getPrice();
		String cType = "'-'";
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();
	    	
	    	String mysqlSt;
	    	mysqlSt= "INSERT into customerorder VALUES ('"+ tno +"','"+ oType +"','"+  ono +"','"+ 
					fType +"','"+ fContent +"','"+ pzsize +"',"+ 
					fAmount +","+ fPrice +",'"+ cType +"')" ;	
	    	
//	    	int rowsUpdated = statement.executeUpdate("INSERT into customerorder VALUES ('abc', 'abc', 'abc', 'abc', 'abc', 'abc' , 1, 1,'abc')");
	    	int rowsUpdated = statement.executeUpdate(mysqlSt);
//	    	
//	    	
//	    	
	    	
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
//	CRUD: Retrieve
	public static void checkMyCart(String oNo) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();
	    	
	    	String mysqlSt;
			mysqlSt= "SELECT * FROM customerorder where OrderNumber = '" + oNo +"'";
	    	ResultSet results = statement.executeQuery(mysqlSt);  	
//	    	need to plan what to do with the result
	    	String TransactionNumber = ""; 
	    	String OrderNumber = ""; 
	    	String OrderType = ""; 
	    	String FoodType = ""; 
	    	String Content = "";
	    	String Size = ""; 
	    	int Amount  = 0;
	    	double Price = 0;  
	    	String CustomerType = "";
	    	System.out.println("TransactionNumber\tOrderNumber\tOrderType\tFoodType\tContent\tSize\tAmount\tPric\tCustomerType");
	    	while(results.next())
	    	{
	    		TransactionNumber = results.getString("TransactionNumber");
	    		OrderNumber = results.getString("OrderNumber");
	    		OrderType = results.getString("OrderType");
	    		FoodType = results.getString("FoodType");
	    		Content = results.getString("Content");
	    		Size = results.getString("Size");
	    		Amount = results.getInt("Amount");
	    		Price = results.getInt("Price");
	    		CustomerType = results.getString("CustomerType");
	    		
	    		System.out.println(TransactionNumber+"\t"+OrderNumber+"\t"+OrderType+"\t"+FoodType
						+"\t"+Content+"\t"+Size+"\t"+Amount+"\t"+Price+"\t"+CustomerType);
	    		
	    		
	       	}
	    	
	    	
	    	
//	    	System.out.println(results);
	    	
	    	results.close();
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
	
//	CRUD: Update
	public static void confirmCustomerType(String oNo, String cusType) {
				try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();
	    	
	    	String mysqlSt;
			mysqlSt= "UPDATE customerorder SET CustomerType = '"+ cusType +"' WHERE OrderNumber = '"+ oNo +"'";
	    	int rowsUpdated = statement.executeUpdate(mysqlSt);
//	    	
//	    	
	    	
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}


//	CRUD: Delete
	public static void deleteOneTsc(String tscNo) {
			try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    }
    try
    {
    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
    	Statement statement = connection.createStatement();
    	
    	String mysqlSt;
		mysqlSt= "DELETE FROM customerorder WHERE TransactionNumber ='"+ tscNo + "'";
    	int rowsUpdated = statement.executeUpdate(mysqlSt);
    	
    	statement.close();
    	connection.close();
    }
    catch(SQLException e) {
    	e.printStackTrace();
	}
		
	}

	public static void deleteAllTsc(String oNo) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();
	    	
	    	String mysqlSt;
			mysqlSt= "DELETE FROM customerorder WHERE OrderNumber = '"+ oNo + "'";
	    	int rowsUpdated = statement.executeUpdate(mysqlSt);
	    	
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
		}
	}
	
}
	    
//	
