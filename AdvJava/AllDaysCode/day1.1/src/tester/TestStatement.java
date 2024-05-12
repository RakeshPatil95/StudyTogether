package tester;

import static utils.DBUtils.openConnection;
import java.sql.*;

public class TestStatement {

	public static void main(String[] args) {
		try (// get fixed db connection from DB Utils
				Connection cn = openConnection();
				// create EMPTY Statement object , to send SQL to the DB
				Statement st = cn.createStatement();
				// execute select query to get a result set consisting of selected rows n cols
				ResultSet rst = st.executeQuery("select * from my_emp");) {
			// RST processing
			while (rst.next())
				System.out.printf("Emp Id %d Name %s Adr %s Salary %.1f Dept Id %s Join Date %s %n",
						rst.getInt(1),
						rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getDate(6));
		}//rst.close ,st.close , cn.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
