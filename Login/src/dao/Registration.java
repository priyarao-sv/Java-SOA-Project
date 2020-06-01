package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration {
	public int RegisterUser(String email, String password) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{		
		Connection con = DBHandler.establishConnection();
		
		String isFound = "No such email in our db";
		PreparedStatement check = con.prepareStatement("select * from Login where email=?");
		check.setString(1, email);
		ResultSet rs = check.executeQuery();
		while(rs.next()){
			if(rs.getString(2).equals(email)){
				isFound = "Success";
			}
		}
		
		int result = -1;

		if(isFound.equals("Success")){
			result = 0;
		} else {
			PreparedStatement ps = con.prepareStatement("insert into Login(email, password, verified_status) values (?, ?, ?)");
			ps.setString(1,  email);
			ps.setString(2,  password);
			ps.setString(3, "not verified");
			result = ps.executeUpdate();
		}
		con.close();
		return result;
	}
}
