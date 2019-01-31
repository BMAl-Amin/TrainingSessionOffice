package io.naztech.crudmicrosoftsql.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {
	
	private static DBConnection dbInstance=null;
	private Connection conn;
	private String connectionUrl;
	
	private DBConnection() {
		Logger log= Logger.getLogger(DBConnection.class.getName());
		// Create a variable for the connection string.
        connectionUrl = "jdbc:sqlserver://vNTDACWSSQLD002:1433;"
        		+ "databaseName=DEV_TEST; user=dev_test_dbo;password=dev_test_dbo123";
        
        try {
        	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        		conn = DriverManager.getConnection(connectionUrl); 
        		log.info("successful");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            log.info("Unsuccessful");
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DBConnection getDbInstance() {
		
		if(dbInstance==null) {
			dbInstance= new DBConnection();
			return dbInstance;
		}else {
			return dbInstance;
		}
		
	}
	public Connection getConnection() {
		return conn;
	}
	
	
}
