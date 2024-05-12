package utils;
import java.sql.*;

public class DBUtils {
	//add a static method to return FIXED DB connection
	public static Connection openConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";

		//get cn from DriverManager : class
		return DriverManager.getConnection(url, "root", "root");
	}

}
