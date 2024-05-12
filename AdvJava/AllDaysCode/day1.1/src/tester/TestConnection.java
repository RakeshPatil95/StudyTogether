package tester;
import static utils.DBUtils.openConnection;
import java.sql.*;

public class TestConnection {

	public static void main(String[] args) {
		try(Connection cn=openConnection())
		{
			System.out.println("Connected to DB "+cn);//imple class instance : MySql specific cn 
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
