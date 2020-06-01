package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLogin {
	public String verifyEmail(String email, String password) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection con = DBHandler.establishConnection();
		
		String isFound = "No such email in our db";
		PreparedStatement ps  = con.prepareStatement("select * from Login where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			if(rs.getString(2).equals(email)){
				if(verifyPassword(password, email)){
					isFound = "Success";
				} else {
					isFound = "Invalid Password";
				}
			}
		}
		con.close();
		return isFound;
	}
	
	public boolean verifyPassword(String password, String email) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
		Connection con = DBHandler.establishConnection();
		
		boolean isFound = false;
		PreparedStatement ps  = con.prepareStatement("select * from Login where password=? and email=?");
		ps.setString(1, password);
		ps.setString(2, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			if(rs.getString(3).equals(password)){
				isFound = true;
			}
		}
		
		con.close();
		return isFound;
	}
	
}
