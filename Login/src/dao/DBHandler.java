package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler {
	
	public static Connection establishConnection() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		Connection con = null;
		
		Properties props = new Properties();
		props.load(new FileInputStream("C:/Users/sharinipriya/Desktop/Login/src/database.properties"));

		Class.forName(props.getProperty("classname"));
		con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
		
		return con;
	}
	
}
