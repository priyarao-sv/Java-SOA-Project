package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VerificationStatus {
	
	public boolean verifyStatus(String email) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		boolean status = false;
		Connection con = DBHandler.establishConnection();
		PreparedStatement ps = con.prepareStatement("update Login set verified_status='verified' where email=?");
		ps.setString(1, email);
		int rowAffected = ps.executeUpdate();
		if(rowAffected > 0){
			status = true;
		}
		return status;
	}
}
